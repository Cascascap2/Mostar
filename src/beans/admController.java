package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.chart.PieChartModel;

import controladores.Manejador;
import logica.modelos.Categorias;
import logica.modelos.Contenido;
	
	
@ManagedBean(name="admContentController")
@ViewScoped

public class admController implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Contenido> cont;
	private List<Categorias> cats;
	private String NombreEmpresa;
	private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private PieChartModel pieModel3;
         
    @ManagedProperty("#{contentController}")
    private contentController service;
     

	public List<Categorias> getCats() {
		return cats;
	}


	

	public PieChartModel getPieModel1() {
		return pieModel1;
	}




	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}




	public PieChartModel getPieModel2() {
		return pieModel2;
	}




	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}




	public PieChartModel getPieModel3() {
		return pieModel3;
	}




	public void setPieModel3(PieChartModel pieModel3) {
		this.pieModel3 = pieModel3;
	}




	public String getNombreEmpresa() {
		return NombreEmpresa;
	}




	public void setNombreEmpresa(String nombreEmpresa) {
		NombreEmpresa = nombreEmpresa;
	}




	public void setCats(List<Categorias> cats) {
		this.cats = cats;
	}




	public List<Contenido> getCont() {
		return cont;
	}




	public void setCont(List<Contenido> cont) {
		this.cont = cont;
	}




	public contentController getService() {
		return service;
	}




	public void setService(contentController service) {
		this.service = service;
	}

	@SuppressWarnings("static-access")
	public Boolean[] getVisible(){
		return service.getEsvisible();
	}

	public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Editando Contenido", ((Contenido) event.getObject()).getName());
        Manejador man = Manejador.getInstance();
        man.getContenidoControlador().modificarContenido((Contenido) event.getObject());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Contenido) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        System.out.println(event.getNewValue().toString());
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Editada", "A remplazar: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    private List<Contenido> filtroNomEmpresa(List<Contenido> conts){
    	List<Contenido> ContPorEmp = new ArrayList<Contenido>();
    	for(int i=0;i<conts.size();i++){
    		if(conts.get(i).getProvider_name().equals(this.NombreEmpresa)){
    			ContPorEmp.add(conts.get(i));
    		}
    	}
    	
    	return ContPorEmp;
    }
    

    private void createPieModels(){
        createPieModel1();
        createPieModel2();
        createPieModel3();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
        for(int i=0;i<cont.size();i++) {
        	pieModel1.set(cont.get(i).getName(),cont.get(i).getVistas());
        }
        
         
        pieModel1.setTitle("Visitas por Contenidos");
        pieModel1.setLegendPosition("e");
        pieModel1.setFill(false);
        pieModel1.setShowDataLabels(true);
        pieModel1.setDiameter(150);
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
         
        for(int i=0;i<cont.size();i++) {
        	pieModel2.set(cont.get(i).getName(),cont.get(i).getLikes());
        }
        
         
        pieModel2.setTitle("'Me Gusta' por Contenidos");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
    
    private void createPieModel3() {
        pieModel3 = new PieChartModel();
         
        for(int i=0;i<cont.size();i++) {
        	pieModel3.set(cont.get(i).getName(),cont.get(i).getDislikes());
        }
        
         
        pieModel3.setTitle("'No Me Gusta' por Contenidos");
        pieModel3.setLegendPosition("e");
        pieModel3.setFill(false);
        pieModel3.setShowDataLabels(true);
        pieModel3.setDiameter(150);
    }
    
    @PostConstruct
    public void init() {
    	FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		userController uc = application.evaluateExpressionGet(context, "#{userController}", userController.class);
		this.NombreEmpresa = uc.getNombreEmpresa();
    	service = new contentController();
    	service.init();
        cont = service.getListCont();
        cont = this.filtroNomEmpresa(cont);
        cats = service.getListCat();
        this.createPieModels();
    }

}
