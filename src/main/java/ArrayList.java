public class ArrayList implements ArrayFunctions {
    private final int initialSize = 10;
    private String[] array = new String[initialSize];
    private int elementsInArray = 0;


    @Override
    public boolean add(int index, String value) {
        if (array.length < index + 4) {
            resize(array.length + index + 4);
        }
        if (array[index] != null) {
            resize(array.length + 1);
            for (int i = array.length - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
        } else array[index] = value;
        array[index] = value;
        elementsInArray++;


        return true;
    }


    @Override
    public boolean add(String value) {
        if (elementsInArray == array.length - 1)
            resize(array.length * 2);
        array[elementsInArray++] = value;
        return true;
    }


    @Override
    public boolean delete(int index) {
        for (int i = index; i < elementsInArray; i++) {
            array[i] = array[i + 1];
            if ((array.length > initialSize) && (elementsInArray < array.length / 4)) {
                resize(array.length / 2);// уменьшить массив, чтобы он безмерно не рос
            }
        }
        array[elementsInArray] = null;
        elementsInArray--;

        return true;
    }

    @Override
    public boolean delete() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                break;
            } else {
                i++;
            }
        }
        elementsInArray--;
        return true;
    }

    @Override
    public String get(int index) {
        System.out.println(array[index]);// Ну либо сделать index-1, чтобы не париться по поводу номера
        return array[index];
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////Доп методы/////////////////////////////////////////////////////

    private void resize(int newLength) {
        String[] newArray = new String[newLength];
        System.arraycopy(array, 0, newArray, 0, elementsInArray);
        array = newArray;
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void getSize() {
        System.out.println(array.length);
    }

    public void getElements() {
        System.out.println(elementsInArray);
    }

}
