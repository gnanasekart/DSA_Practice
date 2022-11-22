package LeetCode_Daily_Practice.Linked_List.Single_Linked_List.List;

public class Nodeimplementation {

    public static void main(String[] args) {
        Node node = new Node();
        node.add(1);
        node.add(2);
        node.add(3);
        node.add(2);
        node.add(1);
//        int[] a = {1,2,3,4,9};
//        node.addAll(a);
        node.print();
        //node.insert(3, -4);
        //node.deleteAll();
        //node.addFirst(11);
        //System.out.println(node.size());
        //System.out.println(node.lastIndexOf(1));
        //node.remove(1);
        //System.out.println(node.get(4));
        //node.removeIndex(4);
       // node.set(1, 10);
        //node.insert(1, 5);
       // node.deleteDuplicates(node.head);
        //node.removeFirstIndex();
        //node.removeLastIndex();
        node.removeAll(1);
        node.print();
    }


}
