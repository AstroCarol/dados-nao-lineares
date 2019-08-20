package AVL;

public class AVL {

    //First No is null
    private No root;

    //Get and Set of Root
    public No getRoot(){
        return root;
    }

    public void setRoot(No root) {
        this.root = root;
    }

    public No insert(int index){
        //Check if the root is null or not for insert new No
        if (getRoot() == null){
            No n = new No(null, index);
            setRoot(n);
            return n;
        }

        //Case the root not null
        No aux = father(root, index);
        No n = new No(aux, index);

        //Compare the index for att the references
        if (aux.getIndex() > n.getIndex())
            aux.setLeft(n);
        else
            aux.setRight(n);

        AttFB(n, 0);
        return n;
    }

    //Functions for searching some No
    public No search(int index){
        return searching(root, index);
    }

    public No searching(No n, int index){
        if (n.getIndex() == index)
            return n;
        else if ((index) < n.getIndex())
            return searching(n.getLeft(), index);
        else
            return searching(n.getRight(), index);
    }

    public No father(No n, int index){
        if (n.type() == 0)
            return n;
        if (index < n.getIndex()){
            if (n.getLeft() == null)
                return n;
            else
                return father(n.getLeft(), index);
        }
        else {
            if (n.getRight() == null)
                return n;
            else
                return father(n.getRight(), index);
        }
    }

    public void AttFB(No son, int action){
        No father = new No(son, son.getIndex());
        father = son.getFather();
        boolean stop = false;
        int left_right_son = 0;

        while (father.getFather() != null && !stop){
            //momentos de desespero: checa qual o lado do filho
            if (son.getIndex() < father.getIndex())
                father.setFb(father.getFB()+(1*action));
            else
                father.setFb(father.getFB()+(-1*action));

            father = father.getFather();

            if (father.getFB() == 0)
                stop = true;

            if (father.getFB() < -1 )
                left_r(father);
            else if (father.getFB() > 1)
                right_r(father);
        }
    }

    private void right_r(No father) {
        
    }

    private void left_r(No father) {
    }
}
