package AVL;

public class No {
    private int index;
    private No father;
    private No left;
    private No right;
    private int fb;
    private int compareto;

    public No(No father, int index){
        this.father = father;
        this.index = index;
        fb = 0;
    }

    //Get and Set of index
    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }

    //Get and Set of father
    public No getFather(){
        return father;
    }

    public void setFather(No father) {
        this.father = father;
    }

    //Get and Set of left
    public No getLeft(){
        return left;
    }

    public void setLeft(No left) {
        this.left = left;
    }

    //Get and Set of right
    public No getRight(){
        return right;
    }

    public void setRight(No right) {
        this.right = right;
    }

    //Get and Set of FB
    public int getFB(){
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }

    public int getCompareto() {return compareto;}

    public void setCompareto(int compareto) {
        this.compareto = compareto;
    }

    //Check if the No is root
    public boolean root(){
        if (this.father == null)
            return true;
        else
            return false;
    }

    //Check if have some left son
    public boolean left_son(){
        if (this.left == null)
            return false;
        else
            return true;
    }

    //Check if have some right son
    public boolean right_son(){
        if (this.right == null)
            return false;
        else
            return true;
    }

    //Check the type of No
    public int type(){
        if ((this.right == null) && (this.left == null))
            return 0;
        else
            return 1;
    }
}
