package com.group.touchefinale.controllers;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.touchefinale.dao.AnnopostRepository;
import com.group.touchefinale.entities.Annopost;

@RestController
public class EmailController {

	@Autowired
	public JavaMailSender emailsender;
	
	@Autowired
	private AnnopostRepository annopostRepository;
	
	 @ResponseBody
	 @GetMapping("/sendEmail")
	 public String sendSimpleEmail() {
	 
	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	         
	        message.setTo("touchefinale4@gmail.com");
	        message.setSubject("Test Recrutement 2.0");
	        message.setText("Hello, Im testing Simple Email");
	 
	        // Send Message!
	        this.emailsender.send(message);
	 
	        return "Email Sent!";
	    }
	 
	 // ////////////////////////////////////////////////////////
	 
	    @ResponseBody
	    @GetMapping("/sendRefusHtmlEmail/{id}")
	    public String sendRefusHtmlEmail(Annopost cl, @PathVariable(name="id") Long id) throws MessagingException {
	 
	    	cl=annopostRepository.findById(id).get();
	    	
	        MimeMessage message = emailsender.createMimeMessage();
	 
	        boolean multipart = true;
	         
	        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
	      
	        
	         String htmlMsg = "<h3>Recrutement 2.0</h3><br><hr>"
	       		  
	       		  +"<h4>Madame, Monsieur "+cl.getPostulant().getNompostulant()+" </h4>"
	       		  +"<h4> Nous avons bien reçu votre candidature concernant" +
	       		  " le poste et nous vous en remercions.</h4>"
	       		  +"<h4>cependant, malgré l'intérêt que suscite votre candidature, nous " +
	       		  "sommes au regret de ne pas pouvoir repondre favorablement à votre demande.</h4>"
	       		  +"<h4>Nous vous souhaitons une bonne suite dans votre carriere.</h4><br>"
	       		  
	       		  +"<h4>Cordialement</h4><br>"
	       		  
	       		  +"<h4> "+cl.getAnnonce().getEntreprise().getNomentreprise()+ " - "
	       		  +cl.getAnnonce().getEntreprise().getNomdurecruteurentreprise()+
	       		  " </h4><br><br>"
	       		  
	       		  +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
	       		  
	       		  
	       		  message.setContent(htmlMsg, "text/html");
	       		  
	       		  helper.setTo("touchefinale4@gmail.com");
	       		  
	       		  helper.setSubject("Recrutement 2.0 - Reponse à votre candidature "+cl.getAnnonce().getNomannonce());
	       		
	     
	        this.emailsender.send(message);
	 
	        return "Email Sent!";
	    	
	    }

// /////////////////////////////////////////////////////////////////////////////
	 
	 
	    @ResponseBody
	    @GetMapping("/sendAcceptHtmlEmail/{id}")
	    public String sendAcceptHtmlEmail(Annopost cl, @PathVariable(name="id") Long id) throws MessagingException {
	 
	    	cl=annopostRepository.findById(id).get();
	 
	        MimeMessage message = emailsender.createMimeMessage();
	 
	        boolean multipart = true;
	         
	        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
	         
	         String htmlMsg = "<h3>Recrutement 2.0</h3><br><hr>"
	       		  
	       		  +"<h4>Madame, Monsieur "+cl.getPostulant().getNompostulant()+" </h4>"
	       		  +"<h4> Nous avons bien reçu votre candidature" +
	       		  " et nous vous en remercions.</h4>"
	       		  
	       		  +"<h4><strong>Nous avons le plaisir de vous informer que votre candidature "
	       		  + " à été retenue.</strong></h4>" +
	       		  "<h4>Nous souhaiterons un entretien complementaire et une serie de tests.</h4>"
	       		  + "<h4>Nous nous tenons à votre disposition pour toutes précisions.</h4>"
	       		  
	       		  +"<h4>Nous vous remercions de bien vouloir prendre contact avec M/Mme/Mlle "
	       		  + " <strong> "+cl.getAnnonce().getEntreprise().getNomdurecruteurentreprise()+
	       		  " </strong> " +
	       		  "au <strong> "+cl.getAnnonce().getEntreprise().getMailutilisateur()
	       		  +" </strong> le plus rapidement possible afin que nous puissons nous rencontrer.\r\n"
	       		  + "</h4><br>"
	       		  
	       		  +"<h4>Cordialement</h4><br>"
	       		  
	       		  +"<h4> "+cl.getAnnonce().getEntreprise().getNomentreprise()+ " - "
	       		  +cl.getAnnonce().getEntreprise().getNomdurecruteurentreprise()+
	       		  " </h4><br><br>"
	       		  
	       		  +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
	       		  
	       		  
	       		  message.setContent(htmlMsg, "text/html");
	       		  
	       		  helper.setTo("touchefinale4@gmail.com");
	       		  
	       		  helper.setSubject("Recrutement 2.0 - Reponse à votre candidature "+cl.
	       		  getAnnonce().getNomannonce());
	       		 
	         
	     
	        this.emailsender.send(message);
	 
	        return "Email Sent!";
	    	
	    }
	    
}
