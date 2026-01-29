# TP Programmation Orientée Objet Avancée  
## Comparaison des assistants de génération de code (ChatGPT, Gemini, Microsoft Copilot)

### Binôme
- Étudiant 1 : Romain LE SOURD
- Étudiant 2 : Julian MAZERAT

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

