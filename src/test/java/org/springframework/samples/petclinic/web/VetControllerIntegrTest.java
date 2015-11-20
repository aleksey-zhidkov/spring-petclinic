package org.springframework.samples.petclinic.web;

import org.junit.Test;
import org.restler.Restler;
import org.restler.spring.mvc.SpringMvcSupport;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class VetControllerIntegrTest {

    private final VetController vetController = new Restler("http://localhost:8080", new SpringMvcSupport()).
        build().
        produceClient(VetController.class);

    @Test
    public void testVetsGet() throws Exception {
        Vets vets = vetController.showResourcesVetList();
        assertThat(vets.getVetList().size(), equalTo(6));
        assertThat(vets.getVetList().get(0).getId(), equalTo(1));
        assertThat(vets.getVetList().get(3).getNrOfSpecialties(), equalTo(1));
    }

    @Test
    public void testVetsGetGeneric() throws Exception {
        List<Vet> vets = vetController.showResourcesVetListGeneric();
        assertThat(vets.size(), equalTo(6));
        assertThat(vets.get(0).getId(), equalTo(1));
        assertThat(vets.get(3).getNrOfSpecialties(), equalTo(1));
    }

}
