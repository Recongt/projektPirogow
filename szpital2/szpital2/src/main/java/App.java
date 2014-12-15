/**
 * Created by GUCIA on 2014-11-24.
 */
//import org.springframework.beans.BeansException;

import HospitalApplication.database.model.Dawca;
import HospitalApplication.database.service.DawcaService;
import HospitalApplication.email.model.Email;
import HospitalApplication.email.service.EmailService;
import HospitalApplication.excel.service.ExcelService;
import HospitalApplication.icd10database.operations.Operations;
import HospitalApplication.icd10database.operations.Test;
import HospitalApplication.layout.okienko;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import org.apache.log4j.Logger;

public class App {

    public static void main(String [] args) {
        System.out.println("load context");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Email email = (Email) context.getBean("email");

        EmailService emService = (EmailService) context.getBean("emailService");
        DawcaService daService = (DawcaService) context.getBean("dawcaService");
        ExcelService exService = (ExcelService) context.getBean("excelService");

        /*
        System.out.println("Realoading database");
        ArrayList<String> paths = emService.reloadDatabase();
        for(String path : paths){
            exService.setPath(path);
            Dawca da = daService.findDawcaByPesel(exService.getPesel());
            if(da != null){
                da.setDateUpdate(exService.getDate());
                da.setHowLongOiom();
                da.setRozpoznanie(exService.getRozpoznanie());
                da.setObserwacje(exService.getObserwacje());
                da.setWywiad(exService.getWywiad());
                new File(exService.getPath()).delete();
                daService.updateDawca(da);
            }
            else{
                da = new Dawca();
                da.setPesel(exService.getPesel());
                da.setDate(exService.getDate());
                da.setDateUpdate(exService.getDate());
                da.setHowLongOiom();
                da.setAge();
                da.setSex();
                da.setRozpoznanie(exService.getRozpoznanie());
                da.setObserwacje(exService.getObserwacje());
                da.setWywiad(exService.getWywiad());
                new File(exService.getPath()).delete();
                daService.persistDawca(da);
            }
        }*/
        System.out.println("Chuj");
        if(emService.checkEmail(email) == true){
            ArrayList<String> paths = emService.downloadExcelFile();
            String pesel = null;
            for(String path : paths){
                 exService.setPath(path);
                 Dawca da = daService.findDawcaByPesel(exService.getPesel());
                if(da != null){
                    da.setDateUpdate(exService.getDate());
                    da.setHowLongOiom();
                    da.setRozpoznanie(exService.getRozpoznanie());
                    da.setObserwacje(exService.getObserwacje());
                    da.setWywiad(exService.getWywiad());
                    new File(exService.getPath()).delete();
                    daService.updateDawca(da);
                }
                else{
                    da = new Dawca();
                    da.setPesel(exService.getPesel());
                    da.setDate(exService.getDate());
                    da.setDateUpdate(exService.getDate());
                    da.setHowLongOiom();
                    da.setAge();
                    da.setSex();
                    da.setRozpoznanie(exService.getRozpoznanie());
                    da.setObserwacje(exService.getObserwacje());
                    da.setWywiad(exService.getWywiad());
                    new File(exService.getPath()).delete();
                    daService.persistDawca(da);
                }
            }
        }
        else {
            System.out.println("nothing new");
            List<Dawca> dawcyDateUpdate = daService.list();
            for(Dawca dawca : dawcyDateUpdate){
                dawca.setHowLongOiom();
                daService.updateDawca(dawca);
            }
        }

        List<Dawca> dawcy = daService.list();
        for(Dawca dawca : dawcy){
            System.out.println("#############################################");
            System.out.println(dawca.getPesel());
            System.out.println(dawca.getDate());
            System.out.println(dawca.getDateUpdate());
            System.out.println(dawca.getHowLongOiom());
            System.out.println(dawca.getAge());
            System.out.println(dawca.getSex());
            System.out.println("Obserwacje: "+dawca.getObserwacje());
            System.out.println("Wywiad: "+dawca.getWywiad());
            System.out.println("Rozpoznanie: "+dawca.getRozpoznanie());
        }


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test(Operations.generateIcd10Dictionary());
            }
        });
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    okienko frame = new okienko();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        context.close();
        }
    }




