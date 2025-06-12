package p53.joc.enums;

public enum EstatCasella {
    
    OS('o'), XS('x'), BUIDA('_'); 
    
    private char id;
    
    private EstatCasella(char id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
       return String.valueOf(id); 
    }
    
}
