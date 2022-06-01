
package states;

public class Money {
    
    private int incomes;
    private int outflows;
    private String titular;
    private int saldoTotal;
    private String tipo;
    
    public Money(String tipo, String titular){
    	this.tipo = tipo;
    	this.titular = titular;   	
    }
      public int getIncomes() {
        return incomes;
    }     

    public void setIncomes(int incomes) {
		this.incomes = incomes;
	}
	public int getOutflows() {
        return outflows;
    }
    public void setOutflows(int outflows) {
		this.outflows = outflows;
	}
	public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;    
    }   
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }      
    public String getTipo() {
		return tipo;
	}    
	public int getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(int saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public void registrarIngreso(int income){
         this.incomes +=income;
    }
    public void registrarEgreso(int outflow){
         this.outflows +=outflow;
    }
    public int saldoTotal(){
      return this.incomes - this.outflows;
    }
    @Override
    public String toString() {
        return String.format("""
            Titular: %s 
            Ingresos: %d 
            Egresos: %d 
            Saldo total: %d
            Tipo: %s""",titular,incomes,outflows,saldoTotal(),tipo);
    }

    
    
}
