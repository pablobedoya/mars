package org.pirateatbay.mars.model;

import java.io.Serializable;

public class IdPartComposto implements Serializable{
 
    private static final long serialVersionUID = 1L;
 
    private long agendamento;
    private long discente;
    
    public IdPartComposto(){
    	
    }
 
    public long getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(long agendamento) {
		this.agendamento = agendamento;
	}

	public long getDiscente() {
		return discente;
	}

	public void setDiscente(long discente) {
		this.discente = discente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public int hashCode() {
        return (int) (getAgendamento() + getDiscente());
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IdPartComposto){
            IdPartComposto idPartComposto = (IdPartComposto) obj;
            return idPartComposto.discente == discente && idPartComposto.agendamento == agendamento;
        }
 
        return false;
    }
    
}