package ALDataAccess.ALDTO;

import ALDataAccess.ALGuardarDatos;

// La clase ALHormigaDTO es una clase de transferencia de datos
//que representa una hormiga con sus atributos y métodos para acceder y modificarlos.

public class ALHormigaDTO {

    private String idHormiga;
    private String tipoHormiga;
    private String sexo;
    private String ingestaNativa;
    private String genoAlimento;
    private String estado;

    public ALHormigaDTO(String idHormiga, String tipoHormiga, String sexo, String ingestaNativa, String genoAlimento,
            String estado) {
        this.idHormiga = idHormiga;
        this.tipoHormiga = tipoHormiga;
        this.sexo = sexo;
        this.ingestaNativa = ingestaNativa;
        this.genoAlimento = genoAlimento;
        this.estado = estado;
    }

    public String getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(String idHormiga) {
        this.idHormiga = idHormiga;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIngestaNativa() {
        return ingestaNativa;
    }

    public void setIngestaNativa(String ingestaNativa) {
        this.ingestaNativa = ingestaNativa;
    }

    public String getGenoAlimento() {
        return genoAlimento;
    }

    public void setGenoAlimento(String genoAlimento) {
        this.genoAlimento = genoAlimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
