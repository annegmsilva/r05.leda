package problems;

import java.util.Arrays;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearchImpl implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer middleIndex = array.length/2;
		Integer floor = null;
		if (x == array[middleIndex]) {
			Integer[] left = Arrays.copyOfRange(array, 0, middleIndex);
			floor = floor(left,x);
		} else if (x < array[middleIndex]) {
			Integer[] left = Arrays.copyOfRange(array, 0, middleIndex);
			floor = floor(left,x);
		} else {
			Integer[] right = Arrays.copyOfRange(array, middleIndex, array.length);
			floor = floor(right,x);
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer middleIndex = array.length/2;
		Integer ceil = null;
		
		if (x == array[middleIndex]) {
			Integer[] right = Arrays.copyOfRange(array, middleIndex, array.length);
			ceil = ceil(right,x);
		} else if (x < array[middleIndex]) {
			Integer[] right = Arrays.copyOfRange(array, middleIndex, array.length);
			ceil = ceil(right,x);
		} else {
			Integer[] left = Arrays.copyOfRange(array, 0, middleIndex);
			ceil = ceil(left,x);
		}
		return ceil;
	}

}
