#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
//#include FuerzaBruta.c

int main()
{
    char cadenaA[] = "Munda Mundo!\0";
    char cadenaB[] = "Mundo\0";
    char falla[] = "Munda Mun.\0";

    printf("cadenaA y cadenaB\n");
    if(FuerzaBruta(cadenaA, cadenaB)==1)
        printf("Coincide con Fuerza Bruta\n");
    else
        printf("No coincide con Fuerza Bruta\n");

    if(RabinKarp(cadenaA, cadenaB)==1)
        printf("Coincide con Rabin-Karp\n");
    else
        printf("No coincide con Rabin-Karp\n");

    printf("\ncadenaA y falla\n");
    if(FuerzaBruta(cadenaA, falla)==1)
        printf("Coincide con Fuerza Bruta\n");
    else
        printf("No coincide con Fuerza Bruta\n");

    if(RabinKarp(cadenaA, falla)==1)
        printf("Coincide con Rabin-Karp\n");
    else
        printf("No coincide con Rabin-Karp\n");

    return 0;
}

int FuerzaBruta(char cadenaA[], char cadenaB[]){
    int i, cont=0;
    for (i=0; i < strlen(cadenaA)-strlen(cadenaB)+1; i++){
        if (cadenaA[i]==cadenaB[0]){
            int j=0;
            for(j; j<strlen(cadenaB); j++){
                if(cadenaA[i+j]==cadenaB[j])
                    cont++;
                else{
                    j=strlen(cadenaB);
                    cont=0;
                }
            }
            if(cont==strlen(cadenaB))
                return 1;
        }
    }

    return 0;
}

int RabinKarp (char cadenaA[], char cadenaB[]){
    int hashA=0, hashB=0;
    int i, cont=0;
    //Calculamos el hash definitivo de B y el primero de A (El cual de estara recalculando)
    for(i=0; i< strlen(cadenaB); i++){
        hashA+=cadenaA[i]*pow(3, i);
        hashB+=cadenaB[i]*pow(3, i);
    }

    //Recorremos la cadena principal
    for(i=0; i<strlen(cadenaA)-strlen(cadenaB)+1; i++){
        //Comparamos si poseen el mismo hash
        if(hashA==hashB){
            //Si es asi, ahora comprobamos que tienen la misma frase
            int j=0;
            for(j; j<strlen(cadenaB); j++){
                if(cadenaA[i+j]==cadenaB[j])
                    cont++;
                else{
                    j=strlen(cadenaB);
                    cont=0;
                }
            }
            if(cont==strlen(cadenaB))
                return 1;
        }
        //Si no coincidieron las frases o hashes, recalculamos el hash de la cadena principal
        hashA = ((hashA - cadenaA[i])/3) + (cadenaA[i+strlen(cadenaB)]*pow(3, strlen(cadenaB)-1));
    }


    return 0;
}
