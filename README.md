# 2023-pwa-d
# Sujet du projet
Notre projet est un gestionnaire de restaurant à déstiner de deux sortes d'utilisateurs :
  - Un administrateur : Le responsable du restaurant, qui peut gérer son stock d'ingrédients, créée des menus, changer le rôle des utilisateurs pour leur permettre d'accéder au stock, création de plats.
  - Un utilisateur : Un utilisateur est le "consommateur", un client du restaurant pour lequel est destiné le projet.
  - Un utilisateur a accès aux menus, aux prix de ces plats et doit pouvoir commander depuis la plateforme qui est normalement une caisse enregistreurse (comme les bornes de commandes dans les restaurants).

# Compilation
- Pout compiler le projet, il faut le lancer avec un editeur de code comme visual studio code, et appuyer sur le bouton de démarrage de l'application.
- Le site est hebergé sur le lien localhost8080.
- Il y a deux parties dans le projet : Une partie administrateur et une partie client.
- Vous pouvez accéder à la partie administrateur avec un compte prédédinie. l'adresse mail est "admin", et le mot de passe est "admin"
- Pour tester la partie admin, vous pouvez :
  - Acceder au stock des ingrédients à l'aide du "bouton" stock management.
  - Ajouter un ou plusieurs ingrédients à la liste du stock à l'aide d'un formulaire accessible depuis le gestionnaire du stock -> bouton "Add ingredient"
  - Créer des plats à l'aide du bouton create dish qui donne accès à un formulaire de création de plats.
  - Créer des menus à l'aide du bouton Menu management qui permet d'ajouter à un menu des plats parmi ceux qui sont disponibles
  - Afficher le contenu de chaque menu créer à l'aide d'un bouton représentant chaque menu présent dans la liste de menu. Cette dernière est accessible depuis le bouton View menu.
- La partie admin intéragi avec la base de données, en suivant le protocole MVC et en faisant des requêtes pour récupérer les données demandées pour afficher les données d'une manière structurées.
  
