package RN;

import AVL.No;

public class NoRN extends No {

    private NoRN prox;
    private NoRN longe;
    private boolean rubro;
    private boolean negro;
    private boolean duplonegro;

    public NoRN(No father, int index) {
        super(father, index);
    }

    public NoRN getProx(){
        return prox;
    }
    public void setProx(NoRN prox){
        this.prox = prox;
    }

    public NoRN getLonge(){
        return longe;
    }

    public void setLonge(NoRN longe){
        this.longe = longe;
    }

    public boolean isNegro(){
        return true;
    }

    public void setNegro(boolean negro){
        this.negro = negro;
    }

    public boolean isRubro(){
        return true;
    }

    public void setRubro(boolean rubro){
        this.rubro = rubro;
    }

    public boolean isDuplonegro(){
        return true;
    }

    public void setDuplonegro(boolean duplonegro){
        this.duplonegro = duplonegro;
    }
}
