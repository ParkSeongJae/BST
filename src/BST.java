
public class BST {

	private Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root ,int input) {
		this.root = root;
		this.root.setValue(input);
	}
	/**BST가 비어있으면 == root 노드가 없으면 참을 리턴하고 root노드가 있는경우 거짓을 리턴한다.*/
	public boolean isEmpty(){
		if(this.root==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void Insert(int input){
		/**root 노드가 없는경우 초기값을 root노드로 설정한다.*/
		if(this.isEmpty()){
			this.root=new Node(input);
		}
		/**root 노드가 존재하는경우 */
		else{
			/**입력값이 루트 보다 작은경우 왼쪽으로 가야한다.*/
			if(root.getValue()>input){
				/**루트의 왼쪽값이 비어있다면 왼쪽에 값을 대입한다.*/
				if(this.root.getLeft()==null){
					Node leftNode=new Node(input);
					this.root.setLeft(leftNode);
				}
				/**왼쪽에 값이 존재하게 되면 이제부터는 재귀적으로 따라가야하기 떄문에 노드를 인자로 주는 Insert 함수로 넘어간다*/
				else{
					Insert(this.root.getLeft(),input);
				}
			}
			/**입력값이 루트값보다 큰경우 오른쪽으로 가야한다*/
			else if(root.getValue()<input){
				/**루트의 오른쪽값이 비어있다면 오른쪽에 값을 대입한다.*/
				if(this.root.getRight()==null){
					Node rightNode=new Node(input);
					this.root.setRight(rightNode);
				}
				/**오른쪽에 값이 존재하게 되면 이제부터는 재귀적으로 따라가야하기 떄문에 노드를 인자로 주는 Insert 함수로 넘어간다*/
				else{
					Insert(this.root.getRight(),input);
				}				
			}
			/**값이 중복되는경우는 생략한다.*/
		}
	}
	/**재귀적으로 돌면서 Insert를 하기위한 함수.
	 * 여기서 Node는 비교를 위한 노드.*/
	private void Insert(Node node,int input){
		/**입력값이 작으면 왼쪽으로 가야한다.*/
		if(node.getValue()>input){
			if(node.getLeft()==null){
				Node leftNode=new Node(input);
				node.setLeft(leftNode);
			}
			else{
				Insert(node.getLeft(),input);
			}
		}
		/**입력값이 큰경우 오른쪽으로 가야한다.*/
		else if(node.getValue()<input){
			if(node.getRight()==null){
				Node rightNode=new Node(input);
				node.setRight(rightNode);
			}
			else{
				Insert(node.getRight(),input);
			}
		}
		
	}
	
	public boolean Search(int input){
		if(!this.isEmpty()){
			if(this.root.getValue()==input){
				return true;
			}
			/**왼쪽으로 가서 찾아야한다.*/
			else if(this.root.getValue()>input){
				if(this.root.getLeft()==null) return false;
				else return Search(this.root.getLeft(),input);
			}
			/**오른쪽으로 가서 찾아야한다.*/
			else{
				if(this.root.getRight()==null) return false;
				else return Search(this.root.getRight(),input);
			}
		}
		/**빈 트리에 검색을 하려고 하는경우*/
		return false;
	}
	/**사용자가 바로 노드에 접근해서 사용하지못하도록 private*/
	private boolean Search(Node node,int input){
		if(node.getValue()==input){
			return true;
		}
		else if(node.getValue()>input){
			if(node.getLeft()==null) return false;
			else return Search(node.getLeft(),input);
		}
		else{
			if(node.getRight()==null) return false;
			else return Search(node.getRight(),input);
		}
	}
	/**삭제가 성공하면 true 실패하면 false를 리턴한다.*/
	public boolean Remove(int input){
		if(!this.isEmpty()){
			/**값이 같은경우 즉 삭제해야하는 경우*/
			if(this.root.getValue()==input){
				/**삭제하려는 경우 경우는 3가지가있다.
				 * 1.리프노드인경우
				 * 2.자식노드가 2개인경우
				 * 3.자식노드가 1개인겨우*/
				if(this.root.getLeft()==null && this.root.getLeft()==null){
					/**리프노드이면서 루트노드인경우 자기 자신만을 없애면 된다.*/
					this.root=null;
					return true;
				}
				else if(this.root.getLeft()!=null && this.root.getRight()!=null){
					/**자식이 둘다 존재하면서 루트노드인경우*/
					
					return true;
				}
				else{
					/**자식이 하나만 존재하는경우*/
					
					return true;
				}
			}
			/**왼쪽으로 가야한다.*/
			else if(this.root.getValue()>input){
				if(this.root.getLeft()==null) return false;
				else return Remove(this.root,this.root.getLeft(),input,true);
			}
			/**오른쪽으로 가야한다.*/
			else{
				if(this.root.getRight()==null) return false;
				else return Remove(this.root,this.root.getRight(),input,false);
			}
		}
		/**트리가 비어있는경우*/
		return false;
	}
	
	/**leftcheck 변수를 사용해서 부모노드가 삭제해야할 Node의 위치를 알 수 있다.*/
	private boolean Remove(Node parents,Node node,int input,boolean leftcheck){
		
		if(node.getValue()==input){
			/**삭제하려는 경우 경우는 3가지가있다.
			 * 1.리프노드인경우
			 * 2.자식노드가 2개인경우
			 * 3.자식노드가 1개인겨우*/
			if(this.root.getLeft()==null && this.root.getLeft()==null){
				/**루트노드가 아니면서 리프노드라면 자기 자신을 지우고 부모와의 링크를 끊어야한다..*/
				node=null;
				if(leftcheck) parents.setLeft(null);
				else parents.setRight(null);
				return true;
			}
			else if(this.root.getLeft()!=null && this.root.getRight()!=null){
				/**자식이 둘다 존재하면서 루트노드가 아닌 경우*/
				
				return true;
			}
			else{
				/**자식이 하나만 존재하는경우*/
				
				return true;
			}
		}
		/**왼쪽으로 가야한다.*/
		else if(node.getValue()>input){
			if(node.getLeft()==null) return false;
			else return Remove(node,node.getLeft(),input,true);
		}
		/**오른쪽으로 가야한다.*/
		else{
			if(node.getRight()==null) return false;
			else return Remove(node,node.getRight(),input,false);
		}
	}
	/**루트로부터 아래로 내려오면서 왼쪽 트리의 순회가 끝나면 오른쪽 트리를 순회하는 방식*/
	public void preorder(){
		if(!this.isEmpty()){
			System.out.println(this.root.getValue());
			if(this.root.getLeft()!=null)preorder(this.root,this.root.getLeft());
			if(this.root.getRight()!=null)preorder(this.root,this.root.getRight());
		}
	}
	private void preorder(Node parents,Node node){
		System.out.println(node.getValue());
		if(node.getLeft()!=null) preorder(node,node.getLeft());
		if(node.getRight()!=null) preorder(node,node.getRight());
	}
	public void inorder(){
		if(!this.isEmpty()){
			findLeftLeafNode();
		}
	}
	private void findLeftLeafNode(){
		
	}

	public void postorder(){
		
	}

}
