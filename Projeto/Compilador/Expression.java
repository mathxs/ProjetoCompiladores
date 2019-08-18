public class Expression{
   private float value;
   
   private AbstractOperand root;
   
   public Expression(){
	   this.root  = null;
	   this.value = 0.0f;
   }
   
   public Expression(AbstractOperand root){
	   this.root  = root;
	   this.value = 0.0f;
   }
   
   public void eval(){
       this.value = this.root.getValue();
   }
   public String toString(){
       return "Expression: "+this.value;
   }

    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * @return the root
     */
    public AbstractOperand getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(AbstractOperand root) {
        this.root = root;
    }
}