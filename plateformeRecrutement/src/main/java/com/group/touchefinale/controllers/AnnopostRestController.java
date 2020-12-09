package com.group.touchefinale.controllers;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.touchefinale.dao.AnnopostRepository;
import com.group.touchefinale.dao.EntrepriseRepository;
import com.group.touchefinale.entities.Annonce;
import com.group.touchefinale.entities.Annopost;
import com.group.touchefinale.entities.Utilisateur;

@CrossOrigin("*")
@RestController
public class AnnopostRestController {
	
	@Autowired
	private AnnopostRepository annopostRepository;
	
	@Autowired
	public JavaMailSender emailsender;
	
	@Autowired
	private EmailController emailController;

	
	  @GetMapping("/idannopost/{idannopost}") 
	  public Annopost idannoposts(@PathVariable(name="idannopost") Long idannopost) {
	  
		  Annopost ann= annopostRepository.findByIdannopost(idannopost);
			if(ann!=null) throw new RuntimeException("Cet id est deja utilisé");
	  return ann;
	  }
	  
	  @GetMapping("/idEntrepriseForAnnopost/{idutilisateur}")
	  public List<Annopost> idEntrepriseForAnnopost(@PathVariable(name="idutilisateur") Long idutilisateur) {		  
		  return  annopostRepository.findByIdentreprise(idutilisateur);	  		  
	  }
	  
	  @GetMapping("/idPostulantForAnnopost/{idutilisateur}")
	  public List<Annopost> idPostulantForAnnopost(@PathVariable(name="idutilisateur") Long idutilisateur) {		  
		  return  annopostRepository.findByIdpostulant(idutilisateur); 		  
	  }
	  
	  @GetMapping("/idAnnonceForAnnopost/{idannonce}")
	  public List<Annopost> idAnnonceForAnnopost(@PathVariable(name="idannonce") Long idannonce) {		  
		  return  annopostRepository.findByIdannonce(idannonce); 		  
	  }
	  
	  @PutMapping("/decisionannopostsx/{id}")
	  public Annopost prendreDecision(@RequestBody Annopost cl, @PathVariable(name="id") Long id) throws MessagingException {		  
	
		  		System.out.println("voir la valeur de decision ==> "+cl.getDecisionannopost());
		  		
		/*
		 * MimeMessage message = emailsender.createMimeMessage();
		 * 
		 * boolean multipart = true;
		 * 
		 * MimeMessageHelper helper = new MimeMessageHelper(message, multipart,
		 * "utf-8");
		 * 
		 * String htmlMsg = "<h3>Recrutement 2.0</h3><br><hr>"
		 * 
		 * +"<h4>Madame, Monsieur "+cl.getPostulant().getNompostulant()+" </h4>"
		 * +"<h4> Nous avons bien reçu votre candidature concernant" +
		 * " le poste et nous vous en remercions.</h4>"
		 * +"<h4>cependant, malgré l'intérê que suscite votre candidature, nous " +
		 * "sommes au regret de ne pas pouvoir repondre favorablement à votre demande.</h4>"
		 * +"<h4>Nous Vous souhaitons une bonne suite dans votre carriere.</h4><br>"
		 * 
		 * +"<h4>Cordialement</h4><br>"
		 * 
		 * +"<h4> "+cl.getAnnonce().getEntreprise().getNomentreprise()+ " - "
		 * +cl.getAnnonce().getEntreprise().getNomdurecruteurentreprise()+
		 * " </h4><br><br>"
		 * 
		 * +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>"
		 * +"<img src='https://fr.wikipedia.org/wiki/Droit_des_marques#/media/Fichier:RegisteredTM.svg'>"
		 * +"<img src='src/main/resources/templates/images/bnb.png'>";
		 * 
		 * 
		 * message.setContent(htmlMsg, "text/html");
		 * 
		 * helper.setTo("touchefinale4@gmail.com");
		 * 
		 * helper.setSubject("Recrutement 2.0 - Reponse à votre candidature "+cl.
		 * getAnnonce().getNomannonce());
		 * 
		 * this.emailsender.send(message);
		 * 
		 */		  	
		/*
		 * if (cl.getDecisionannopost()=="accepte") {
		 * 
		 * MimeMessage message = emailsender.createMimeMessage();
		 * 
		 * boolean multipart = true;
		 * 
		 * MimeMessageHelper helper = new MimeMessageHelper(message, multipart,
		 * "utf-8");
		 * 
		 * String htmlMsg = "<h3>Recrutement 2.0</h3><br><hr>"
		 * 
		 * +"<h4>Madame, Monsieur "+cl.getPostulant().getNompostulant()+" </h4>"
		 * +"<h4> Nous avons bien reçu votre candidature" +
		 * " et nous vous en remercions.</h4>"
		 * 
		 * +"<h4><strong>Nous avons le plaisir de vous informer que votre candidature "
		 * + " à été retenue.</strong></h4>" +
		 * "<h4>Nous souhaiterons un entretien complementaire et une serie de tests.</h4>"
		 * + "<h4>Nous nous tenons à votre disposition pour toutes précisions.</h4>"
		 * 
		 * +"<h4>Nous vous remercions de bien vouloir prendre contact avec M/Mme/Mlle "
		 * + " <strong> "+cl.getAnnonce().getEntreprise().getNomdurecruteurentreprise()+
		 * " </strong> " +
		 * "au <strong> "+cl.getAnnonce().getEntreprise().getMailutilisateur()
		 * +" </strong> le plus rapidement possible afin que nous puissons nous rencontrer.\r\n"
		 * + "</h4><br>"
		 * 
		 * +"<h4>Cordialement</h4><br>"
		 * 
		 * +"<h4> "+cl.getAnnonce().getEntreprise().getNomentreprise()+ " - "
		 * +cl.getAnnonce().getEntreprise().getNomdurecruteurentreprise()+
		 * " </h4><br><br>"
		 * 
		 * +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
		 * 
		 * 
		 * message.setContent(htmlMsg, "text/html");
		 * 
		 * helper.setTo("touchefinale4@gmail.com");
		 * 
		 * helper.setSubject("Recrutement 2.0 - Reponse à votre candidature "+cl.
		 * getAnnonce().getNomannonce());
		 * 
		 * 
		 * this.emailsender.send(message);
		 * 
		 * }
		 * 
		 */		  	cl.setIdannopost(id);
		  	
			return annopostRepository.save(cl);	
	  }
	 
	// ///////////////////////////////// Methodes classiques /////////////////////////:
	  
	@GetMapping("/annopostsx")
	public List<Annopost> listeAnnopost(){	
		List<Annopost>cl=annopostRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/annopostsx/{id}")
	public Annopost listeAnnopostId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);
		return annopostRepository.findById(id).get();
	}
	
	
	@PostMapping("/annopostsx")	
	public Annopost saveAnnopost(@RequestBody Annopost cl) {
		
		cl.setDecisionannopost("En attente");
		cl.setDatecreationannopost(new Date());
		
		return annopostRepository.save(cl);
	}
	
	@PutMapping("/annopostsx/{id}")
	public Annopost updateAnnopost(@RequestBody Annopost cl, @PathVariable(name="id") Long id) {
		cl.setIdannopost(id);
		return annopostRepository.save(cl);
	}
	
	@DeleteMapping("annopostsx/{id}")
	public List<Annopost> deleteAnnopost(@PathVariable(name="id") Long id) {
		annopostRepository.deleteById(id);			
			return annopostRepository.findAll();
	}

}

