/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author Valdo
 */
public class MergeSort implements AlgoritmoOrdenamiento{
    private double arreglo[];
    private double tt;
    
    public MergeSort(){
        arreglo = null;
    }
    
    @Override
    public void definirDatos(double arreglo[]){
        this.arreglo = arreglo;
    }
    
    @Override
    public void ordenarDatos(){
        // calcular cuando empieza 
        double ti = System.currentTimeMillis();
        
        mergeSort(arreglo,0,arreglo.length-1);
        
        // calculamos el tiempo cuando termina 
        double tf = System.currentTimeMillis();
        this.tt = tf - ti;
        // calculamos el tiempo total
    }
    
    void merge(double Arr[], int start, int mid, int end) {

	// create a temp array
	double temp[] = new double[end - start + 1];

	// crawlers for both intervals and for temp
	int i = start, j = mid+1, k = 0;

	// traverse both arrays and in each iteration add smaller of both elements in temp 
	while(i <= mid && j <= end) {
            if(Arr[i] <= Arr[j]) {
                temp[k] = Arr[i];
                k += 1; i += 1;
            }
            else {
		temp[k] = Arr[j];
                k += 1; j += 1;
            }
	}

	// add elements left in the first interval 
	while(i <= mid) {
            temp[k] = Arr[i];
            k += 1; i += 1;
	}

	// add elements left in the second interval 
	while(j <= end) {
            temp[k] = Arr[j];
            k += 1; j += 1;
	}

	// copy temp to original interval
	for(i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
	}
    }

    // Arr is an array of integer type
    // start and end are the starting and ending index of current interval of Arr

    void mergeSort(double Arr[], int start, int end) {

        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid);
            mergeSort(Arr, mid+1, end);
            merge(Arr, start, mid, end);
        }
    }
    
    public double getTt() {
        return tt;
    }
}
