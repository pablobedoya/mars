package org.pirateatbay.mars.model;

import java.io.Serializable;

public class ParticipanteId implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private long agendamento;
    private long discente;
    
    public ParticipanteId(){
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
        if(obj instanceof ParticipanteId){
            ParticipanteId participanteId = (ParticipanteId) obj;
            return participanteId.agendamento == agendamento && participanteId.discente == discente;
        }
 
        return false;
    }
    
}