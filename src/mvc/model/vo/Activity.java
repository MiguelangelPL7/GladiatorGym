package mvc.model.vo;

public class Activity {
    private int CodigoActividad;
    private int ActividadPID;
    private String ActividadHorario;
    private String MonitorDNI;
    private boolean ActividadDisponibilidad;
    private int CapacidadMaxima;

    ///GETTERS AND SETTERS///

    ///CodigoActividad///
    public int getCodigoActividad() { return CodigoActividad; }

    public void setCodigoActividad(int CodigoActividad) { this.CodigoActividad = CodigoActividad; }

    ///ActividadPID///
    public int getActividadPID()
    {
        return ActividadPID;
    }

    public void setActividadPID(int ActividadPID)
    {
        this.ActividadPID = ActividadPID;
    }

    ///ActividadHorario///
    public String getActividadHorario()
    {
        return ActividadHorario;
    }

    public void setActividadHorario(String ActividadHorario)
    {
        this.ActividadHorario = ActividadHorario;
    }

    ///MonitorDNI///
    public String getMonitorDNI()
    {
        return MonitorDNI;
    }

    public void setMonitorDNI(String MonitorDNI)
    {
        this.MonitorDNI = MonitorDNI;
    }

    ///ActividadDisponibilidad///
    public boolean getActividadDisponibilidad()
    {
        return ActividadDisponibilidad;
    }

    public void setActividadDisponibilidad(boolean ActividadDisponibilidad)
    {
        this.ActividadDisponibilidad = ActividadDisponibilidad;
    }

    ///CapacidadMaxima///
    public int getCapacidadMaxima()
    {
        return CapacidadMaxima;
    }

    public void setCapacidadMaxima(int CapacidadMaxima)
    {
        this.CapacidadMaxima = CapacidadMaxima;
    }
}
