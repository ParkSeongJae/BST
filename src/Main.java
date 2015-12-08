
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst=new BST();
		bst.Insert(30);
		bst.Insert(20);
		bst.Insert(40);
		bst.Insert(10);
		bst.Insert(25);
		bst.Insert(35);
		bst.Insert(45);
		bst.Insert(5);
		bst.Insert(27);
		bst.Insert(38);
		bst.Insert(43);
		bst.Insert(47);
		
		System.out.println(bst.isEmpty());
		
		bst.preorder();

		
	}

}
