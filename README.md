## BINÔME : Pape Boubacar DIALLO & Magou GUEYE

### Langage : Java (Spring Boot)

### Outils utilisés :
- JUnit pour tests unitaires
- Selenium pour les tests fonctionnels
- Jenkins puis migration vers GitLab CI/CD
- Docker et Docker Hub
- Kubernetes

### Stages du pipeline :
✅ Récupération du code source depuis un SCM (GitLab)  
✅ Build du projet  
✅ Exécution des tests unitaires  
✅ Exécution des tests IHM (pour le front)  
✅ Vérification de la qualité logicielle  
✅ Packaging de l’artéfact  
✅ Création d’une image Docker  
✅ Dépôt des artéfacts dans un repository local pour les environnements de dev et staging, dans un repository public pour les environnements de préprod & prod  
✅ Push de l’image dans un registry local pour les env de dev & staging ; dans un registry distant pour les env de préprod & prod  
✅ Provisioning automatique de l’environnement cible  
✅ Déploiement automatique des images de notre application monolithique dans l’environnement cible  

### Exigences (2/2) :
❌ Exigence 2 non remplie
