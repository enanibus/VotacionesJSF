package votaciones.controllers.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import votaciones.controllers.ejb.VotacionesEjb;
import votaciones.models.entities.Voto;

@ManagedBean
public class VotacionesBeanJSF {

	public VotacionesBeanJSF() {
	}

	public List<Voto> getVotaciones() {
		return VotacionesEjb.votaciones();
	}

	public void setVotaciones(List<Voto> votaciones) {
	}

}