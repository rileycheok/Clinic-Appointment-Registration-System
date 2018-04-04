/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.ConsultationEntity;
import java.util.List;
import javax.ejb.Remote;
import util.exception.EntityManagerException;

/**
 *
 * @author Shi Yun
 */
@Remote
public interface ConsultationEntityControllerRemote {
    
    ConsultationEntity createNewConsultation(ConsultationEntity newConsultationEntity);

    List<ConsultationEntity> retrieveAllConsultations();

    ConsultationEntity retrieveConsultationByConsultationId(Long consultationId) throws EntityManagerException;

    void updateConsultation(ConsultationEntity consultationEntity);

    void deleteConsultation(Long consultationId) throws EntityManagerException;

    void deleteAllConsultations() throws EntityManagerException;

}
