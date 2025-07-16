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
		Integer floor = null;
		if (array.length > 0) {
			Integer middleIndex = array.length/2;
			if (x == array[middleIndex]) {
				floor = array[middleIndex];
			} else if (x < array[middleIndex]) {
				Integer[] left = Arrays.copyOfRange(array, 0, middleIndex);
				floor = floor(left,x);
			} else {
				Integer[] right = Arrays.copyOfRange(array, middleIndex + 1, array.length);
				floor = floor(right,x);
				if (floor == null) {
					floor = array[middleIndex];
				}
			}
		}
		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer ceil = null;
		if (array.length > 0) {
			Integer middleIndex = array.length/2;
			if (x == array[middleIndex]) {
				ceil = array[middleIndex];
			} else if (x > array[middleIndex]) {
				Integer[] right = Arrays.copyOfRange(array, middleIndex + 1, array.length);
				ceil = ceil(right,x);
			} else {
				Integer[] left = Arrays.copyOfRange(array, 0, middleIndex);
				ceil = ceil(left,x);
				if (ceil == null) {
					ceil = array[middleIndex];
				} 
			}
		}
		return ceil;
	}

}
