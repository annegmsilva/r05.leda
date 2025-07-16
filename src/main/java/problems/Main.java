package problems;

public class Main {

    public static void main(String[] args) {
		Integer[] array = {4,6,8,10};
        FloorCeilBinarySearchImpl f = new FloorCeilBinarySearchImpl();
		Integer valor = f.ceil(array,7);
		System.out.println(valor);
	}

}
