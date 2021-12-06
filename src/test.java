public class test {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("isEmpty: " + list.isEmpty());

        list.add("1");
        list.add("2");
        list.add("3");

        System.out.println("isEmpty: " + list.isEmpty());
        System.out.println(list.toString());

        System.out.println("Elem 0: " + list.get(0));

        list.set(1,"4");
        System.out.println("Set 4, ind 1:\n" + list.toString());


        System.out.println("3 contains: " + list.contains("3"));
        System.out.println("2 contains: " + list.contains("2"));

        list.remove("3");
        System.out.println("Remove 3:\n" + list.toString());

        list.remove(0);
        System.out.println("Remove 0 ind:\n" + list.toString());

        list.add(0, "5");
        System.out.println("insert 5 to 0 ind: \n" + list.toString());

        list.add("6");
        System.out.println("insert 6: \n" + list.toString());
    }
}
