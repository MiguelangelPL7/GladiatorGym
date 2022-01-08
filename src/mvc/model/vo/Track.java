package mvc.model.vo;

public class Track {
    private int CodigoPista;
    private int PistaPID;
    private String PistaHorario;
    private int MiembroID;
    private boolean PistaDisponibilidad;
    private double PrecioPorHora;

    ///GETTERS AND SETTERS///

    ///CodigoPista///
    public int getCodigoPista()
    {
        return CodigoPista;
    }

    public void setCodigoPista(int CodigoPista)
    {
        this.CodigoPista = CodigoPista;
    }

    ///PistaPID///
    public int getPistaPID()
    {
        return PistaPID;
    }

    public void setPistaPID(int PistaPID)
    {
        this.PistaPID = PistaPID;
    }

    ///PistaHorario///
    public String getPistaHorario()
    {
        return PistaHorario;
    }

    public void setPistaHorario(String PistaHorario)
    {
        this.PistaHorario = PistaHorario;
    }

    ///PrecioPorHora///
    public double getPrecioPorHora()
    {
        return PrecioPorHora;
    }

    public void setPrecioPorHora(double PrecioPorHora)
    {
        this.PrecioPorHora = PrecioPorHora;
    }

    ///PistaDisponibilidad///
    public boolean getPistaDisponibilidad()
    {
        return PistaDisponibilidad;
    }

    public void setPistaDisponibilidad(boolean PistaDisponibilidad)
    {
        this.PistaDisponibilidad = PistaDisponibilidad;
    }

    ///MiembroID///
    public int getMiembroID()
    {
        return MiembroID;
    }

    public void setMiembroID(int MiembroID) { this.MiembroID = MiembroID; }
}
