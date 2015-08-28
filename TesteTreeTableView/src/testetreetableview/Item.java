/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testetreetableview;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author gustavomaia
 */
public class Item {
    
    private DoubleProperty num, valor;
    private StringProperty desc;
    private IntegerProperty qtd;

    public Item(Double item, String descricao, Integer qtde, Double total) {
        
        if(item==null){
            num = new SimpleDoubleProperty();
        }else{
            num = new SimpleDoubleProperty(item);
        }
        
        if(descricao==null){
            desc = new SimpleStringProperty();
        }else{
            desc = new SimpleStringProperty(descricao);
        }
        
        if(total == null){
            valor = new SimpleDoubleProperty();
        }else{
            valor = new SimpleDoubleProperty(total);
        }
        
        if(qtde == null){
            qtd = new SimpleIntegerProperty();
        }else{
            qtd = new SimpleIntegerProperty(qtde);
        }
        
    }

    public Double getNum() {
        return num.get();
    }
    public void setNum(Double num) {
        this.num.set(num);
    }
    public DoubleProperty numProperty(){
        return this.num;
    }

    public Double getValor() {
        return valor.get();
    }
    public void setValor(Double valor) {
        this.valor.set(valor);
    }
    public DoubleProperty valorProperty(){
        return this.valor;
    }

    public String getDesc() {
        return desc.get();
    }
    public void setDesc(String desc) {
        this.desc.set(desc);
    }
    public StringProperty descProperty(){
        return this.desc;
    }

    public Integer getQtd() {
        return qtd.get();
    }
    public void setQtd(Integer qtd) {
        this.qtd.set(qtd);
    }
    public IntegerProperty qtdProperty(){
        return this.qtd;
    }    
    
}
