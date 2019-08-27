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

        AttFB(n, 1);
        return n;
    }

    public void remove(No no){
        if(no.type() == 0) {
            if (no.getIndex() > no.getFather().getIndex()) {
                no.getFather().setRight(null);
                no.setFather(null);
            } else {
                no.getFather().setLeft(null);
                no.setFather(null);
            }
        }
        AttFB(no, -1);
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

    public No successor(No no){

        if (no.type() == 0 || no.getLeft() == null)
            return no;
        else
            return successor(no.getLeft());

        /*if (no.getRight().getLeft() == null)
            return no.getRight();
        else if (no.getRight().getLeft() != null)
            return successor(no.getRight().getLeft());
        else
            return no;*/
    }

    public void AttFB(No son, int action){
        //No father = new No(son, son.getIndex());
        boolean stop = false;
        int left_right_son = 0;

        while (son.getFather() != null && !stop ){
            //momentos de desespero: checa qual o lado do filho

            if(action == 1){
                if (son.getIndex() < son.getFather().getIndex())
                    son.getFather().setFb(son.getFather().getFB() + (1 * action));
                else
                    son.getFather().setFb(son.getFather().getFB() + (-1 * action));
            }
            else if (action == -1){
                if (son.getIndex() < son.getFather().getIndex())
                    son.getFather().setFb(son.getFather().getFB() + (-1 * action));
                else
                    son.getFather().setFb(son.getFather().getFB() + (1 * action));
            }

            if (son.getFather().getFB() < -1 ) {
                if (son.getFB() < 0) {
                    //System.out.println("esquerda");
                    left_r(son.getFather());
                }
                else if (son.getFB() == 1)
                    left_2r(son.getFather());
            }
            else if (son.getFather().getFB() > 1){
                if (son.getFB() > 0)
                    right_r(son.getFather());
                else if (son.getFB() == -1)
                    right_2r(son.getFather());
            }

            //son = son.getFather();

            if (son.getFB() == 0)
                stop = true;
        }
    }

    private void right_r(No father) {
        No B = father;
        No A = father.getLeft();
        int fb_a_novo, fb_b_novo = 0;

        B.setLeft(A.getRight());
        A.setRight(A.getFather());
        A.setFather(B.getFather());
        B.setFather(A);

        fb_b_novo = B.getFB() - 1 - Math.max(A.getFB(), 0);
        fb_a_novo = A.getFB() - 1 + Math.min(fb_b_novo, 0);

        A.setFb(fb_a_novo);
        B.setFb(fb_b_novo);
    }

    private void left_r(No father) {
        No B = father;
        No A = father.getRight();
        int fb_a_novo, fb_b_novo = 0;

        B.setRight(A.getLeft());
        A.setLeft(A.getFather());
        A.setFather(B.getFather());
        B.setFather(A);

        fb_b_novo = B.getFB() + 1 - Math.min(A.getFB(), 0);
        fb_a_novo = A.getFB() + 1 + Math.max(fb_b_novo, 0);

        A.setFb(fb_a_novo);
        B.setFb(fb_b_novo);
    }

    private void right_2r(No father){
        left_r(father);
        right_r(father);
    }

    private void left_2r(No father){
        right_r(father);
        left_r(father);
    }

    public void print(){
        StringBuffer out = new StringBuffer();
        this.root.printTree(out);
        System.out.println(out);
    }
}
