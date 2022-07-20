# beautifulSpring
Thymeleaf + Spring Security + Spring MVC + Spring Data JPA + MySQL DB

# Arhitektura aplikacije

## Koristimo pristup -> skačemo sa page na page -> Spring MVC

		  
		  
		 -> Thymeleaf + Spring Security + Spring MVC + Spring Data JPA + MySQL
		 -> Spring BOOT RAD
     
		 
		
		  -> Kada dodamo u pom.xml Spring Security library automatski su pristupi svim .html(views) stranicam osigurani i moraju proći naš security.
			
      -> Spring Security po defaultu koristi svoj interni UserDetails objekat i redirecta nas na login page koji dobijemo 
      gratis. Podaci iz login page-a bivaju submitani na Spring Security koji dalje preko UserDetailsService radi upit na UserDetails.
      -> Defaultni UserDetails objekat biva kreiran sa username:"user" i lozinkom:"izgenerisanom u konzoli".
      -> Mi ne želimo naravno takvo ponašanje. Mi želimo vezu između UserDetails Springovog objekta i našeg User objekta 
      kojeg punimo iz baze naših korisnika(MySQL).
			
	    #### Kako konfigurisati Spring Security ???
			Korak 1: Napraviti poveznicu između User i UserDetails -> CustomUserDetails
			Korak 2: Napraviti CustomUserDetailsService implements UserDetailsService
			username, password
			Korak 3: Konfigurisati BCryptPasswordEncoder odnosno reći Spring Security-u da koristi naš odabrani 
      mehanizam hashiranja lozinke.
			
			
		Smeta nam nekoliko stvari:
		1. Hoćemo svoj login.html
		    1.1 handle http GET request http://localhost:8080/login
			   1.2 WebSecurityConfigurer
		
		2. Hoćemo da možemo pristupiti register stranici bez da se moramo logovati preko login page ...
		3. logout pristup takođe mora biti slobodan
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
