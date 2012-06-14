package org.projekt.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import org.projekt.domain.Sklep;
import org.projekt.service.SklepService;


@SessionScoped
@Named
public class SklepBean implements Serializable {
    
    private ListDataModel<Sklep> sklepy = new ListDataModel<Sklep>();
    private Sklep sklep;
    
    @Inject
    private SklepService sklepService;

    public ListDataModel<Sklep> getSklepy() {
        sklepy.setWrappedData(sklepService.getSklepy());
        return sklepy;
    }

    public Sklep getSklep() {
        return sklep;
    }

    public void setSklep(Sklep sklep) {
        this.sklep = sklep;
    }
    
    public String addSklep() {
        sklep = new Sklep();
        return "add";
    }
    
    public String editSklep() {
        sklep = sklepy.getRowData();
        return "edit";
    }
    
    public String delete() {
        Sklep sklep = sklepy.getRowData();
        sklepService.delete(sklep);
        return "sklepy";
    }
    
    public String show() {
        sklep = sklepy.getRowData();
        return "show";
    }
    
    public String update() {
        sklepService.update(sklep);
        return "sklepy";
    }
}