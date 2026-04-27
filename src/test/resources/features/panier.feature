# language: fr
Feature: Gestion du panier
  En tant qu'utilisateur
  Je veux ajouter un produit au panier
  Afin de voir le compteur se mettre à jour immédiatement

  Scenario: Ajouter un produit au panier
    Given je suis sur la page d'accueil du site
    When je clique sur le bouton "Ajouter au panier"
    Then le compteur du panier doit afficher "1"
