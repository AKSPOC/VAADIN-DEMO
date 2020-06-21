package com.example.demo.ui;

import com.example.demo.dao.ProfileDao;
import com.example.demo.repository.ProfileRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.Collection;

@Route("index")
public class IndexUI extends VerticalLayout {
    @Autowired
    ProfileRepository profileRepository;

    Button bookAppointment;
    Button showAppointment;
    GridCrud<ProfileDao> crud = new GridCrud<>(ProfileDao.class);


    public IndexUI() {
        Dialog dialog = new Dialog();
        dialog.setResizable(true);
        dialog.setDraggable(true);
        Div div = new Div();
        crud.setCrudListener(new CrudListener<ProfileDao>() {
            @Override
            public Collection<ProfileDao> findAll() {
                return profileRepository.findAll();
            }

            @Override
            public ProfileDao add(ProfileDao user) {
                return profileRepository.save(user);
            }

            @Override
            public ProfileDao update(ProfileDao user) {
                return profileRepository.save(user);
            }

            @Override
            public void delete(ProfileDao user) {
                profileRepository.delete(user);
            }
        });
        bookAppointment =crud.getAddButton();
        showAppointment=crud.getFindAllButton();
        showAppointment.setText("Show Appointment");
        bookAppointment.setText("Book Appointment");
        add(bookAppointment);
        add(showAppointment);
        showAppointment.addClickListener(buttonClickEvent -> {
            div.add(crud.getGrid());
            dialog.add(div);
            dialog.open();
        });
    }

}
