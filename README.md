# TP Programmation Orientée Objet Avancée  
## Comparaison des assistants de génération de code (ChatGPT, Gemini, Microsoft Copilot)

### Binôme
- Romain LE SOURD
- Julian MAZERAT

---

## 1. Contexte et objectifs du TP

L’objectif de ce TP est d’expliquer, appliquer et comparer différents outils d’assistance à la génération de code basés sur l’intelligence artificielle, à savoir :

- ChatGPT (OpenAI)
- Gemini (Google)
- Copilot (Microsoft)

Ces outils sont évalués dans le cadre du développement d’une même application orientée objet, afin d’analyser la qualité du code généré, la pertinence des choix de conception et le respect des principes de la programmation orientée objet.

---

## 2. Application choisie

### 2.1 Description générale

L’application développée est une **application de gestion hôtelière simplifiée**, réalisée en **Java**.

Elle permet de :
- Gérer des chambres d’hôtel
- Gérer des clients
- Créer des réservations
- Calculer le prix d’une réservation selon le type de chambre

L’application est volontairement limitée à une **version console**, afin de se concentrer sur la conception orientée objet et la qualité du code.

---

### 2.2 Contraintes communes imposées aux IA

Afin de garantir une comparaison équitable, les contraintes suivantes ont été imposées à chaque outil :

- Langage : Java
- Paradigme : Programmation Orientée Objet
- Application console (pas d’interface graphique)
- Utilisation de l’héritage et du polymorphisme
- Code structuré, lisible et commenté
- Aucune base de données
- Aucune bibliothèque externe

---

## 3. Organisation du dépôt Git

Le dépôt est structuré de la manière suivante :

hotel-management-ai/  
│  
├── chatgpt/  
│ └── src/  
│  
├── gemini/  
│ └── src/  
│  
├── copilot/  
│ └── src/  
│  
└── README.md  
└── .gitignore    

Chaque dossier contient une implémentation complète et indépendante de la même application, générée par l’outil correspondant. Le prompt utilisé pour générer l'application est identique pour chaque outil IA afin de garantir une comparaison objective et équitable des résultats, basée les mêmes critères.
Le prompt est le suivant : 

Tu es un assistant de développement logiciel.

Génère une application de gestion hôtelière simplifiée en Java en respectant strictement les contraintes suivantes :

- Application console uniquement
- Programmation orientée objet
- Code clair, structuré et commenté
- Aucune base de données
- Aucune bibliothèque externe

Fonctionnalités attendues :
- Gestion des chambres
- Gestion des clients
- Création de réservations
- Calcul du prix d’une réservation

Contraintes de conception :
- Utiliser l’héritage (ex : ChambreStandard, ChambreLuxe)
- Utiliser le polymorphisme pour le calcul du prix
- Respecter l’encapsulation
- Fournir un point d’entrée avec une classe Main
- Fournir un exemple d’utilisation dans la méthode main

Merci de fournir l’ensemble des classes nécessaires avec une architecture orientée objet cohérente.

---

## 4. Description des implémentations

### 4.1 Implémentation avec ChatGPT
- Description générale :  
À partir du prompt fourni, ChatGPT a généré une application de gestion hôtelière simplifiée en Java, fonctionnant en mode console et respectant les principes fondamentaux de la programmation orientée objet.  
L’application est structurée autour des classes suivantes :  
Chambre (classe abstraite)  
ChambreStandard et ChambreLuxe (héritage)  
Client  
Reservation  
Hotel  
Main (point d’entrée)  
La logique métier est clairement séparée. Les chambres encapsulent leur propre logique de calcul de prix. Les réservations associent un client, une chambre et une durée. La classe Hotel centralise la gestion des entités.   
Le calcul du prix d’une réservation repose sur le polymorphisme, chaque type de chambre redéfinissant sa propre méthode de calcul.  
Un exemple d’utilisation est fourni dans la méthode main, permettant de créer des objets et d’afficher une réservation dans la console.  
  
- Points forts observés :  
  - Respect des principes de la POO  
  - Architecture claire et lisible
  - Code compréhensible et commenté
  - Conformité au prompt  
  
- Limites observées :
  - pas d'interface console après le 1er prompt
  - après 2e prompt pour ajouter une interface console, celle-ci est faite avec l'objet Scanner (mais ChatGPT n'explique pas son utilisation) et l'implémentation pour céer une réservation est mauvaise d'un point de vue conception, non généralisable car elle prend le 1er nom de la liste avec la 1ere chambre de la liste.

---

### 4.2 Implémentation avec Gemini
- Description générale :
L’application produite par Gemini est un système de gestion hôtelière en Java, fonctionnant intégralement en mode console.  
L'architecture repose sur une séparation des entités métiers :  
  - Modèle de données : Une classe abstraite Chambre définit le socle commun, déclinée en deux sous-classes spécialisées : ChambreStandard et ChambreLuxe.  
  - Logique de calcul : Le polymorphisme est utilisé pour traiter les spécificités tarifaires (frais de service fixes pour le luxe vs tarif linéaire pour le standard).  
  - Gestion des flux : Une classe Reservation fait le lien entre un objet Client et un objet Chambre, centralisant la génération de la facture.  
  - Interface : Le point d'entrée (main) simule un catalogue de chambres et permet une interaction interactive via la classe Scanner.  
    
- Points forts observés :  
  - Compréhension contextuelle  
  - Utilisation pertinente des concepts POO
  - Lisibilité et Sémantique
  
- Limites observées :  
  - Architecture monolithique  
  - Attributs superflus  
  - Fragilité de l'interface
  - Encapsulation partielle  

---

### 4.3 Implémentation avec Microsoft Copilot
- Description générale :
- Points forts observés :
- Limites observées :

---
