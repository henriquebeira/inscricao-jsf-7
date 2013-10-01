/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package inscricao.faces.mngbeans;

import inscricao.entity.Candidato;
import inscricao.faces.mngbeans.InscricaoBean;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;

/**
 *
 * @author a1156462
 */
@ManagedBean
@ApplicationScoped
public class ListaCandidatosBean implements Serializable {

    private ArrayList<Candidato> listaCandidatos;
    private ListDataModel<Candidato> candidatoDataModel;
    
    public ListaCandidatosBean() {
        listaCandidatos = new ArrayList<Candidato>();
        candidatoDataModel = new ListDataModel<>(listaCandidatos);
    }
    
    public ListDataModel<Candidato> getCandidatoDataModel() {
        return candidatoDataModel;
    }
               
    public void adicionarCandidato(Candidato candidato) {
        if (listaCandidatos != null) {
            listaCandidatos.add(candidato);
        }
    }
    
    public void removerCandidato(Candidato candidato) {
        if (listaCandidatos != null) {
            listaCandidatos.remove(candidato);
        }
    }

    public Candidato getCandidato(long cpf) {
        for (Candidato cand : listaCandidatos) {
            if (cand.getCpf() == cpf) {
                return cand;
            }
        }
        return null;
    }
    
    public void setListaCandidatos(ArrayList<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public ArrayList<Candidato> getListaCandidatos() {
        if (listaCandidatos != null) {
            return listaCandidatos;
        }
        listaCandidatos = new ArrayList<Candidato>();
        return listaCandidatos;
    }
    
    public void alterarCandidato(Candidato candidato) {
        if (listaCandidatos != null) {
            for (Candidato cand : listaCandidatos) {
                if (cand.getCpf() == candidato.getCpf()) {
                    listaCandidatos.remove(cand);
                    listaCandidatos.add(candidato);
                    return;
                }
            }
        }
    }
    
}


