/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
angular.module('monApp', ['ngRoute','ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
    $routeProvider
     .when('/', {
        controller: "MedicController as ctrl",
        templateUrl: 'accueil.html'    
    })
//     .when('/crayon/edit/:id', {
//        controller: "CrayonEditController as ctrl",
//        templateUrl: 'editCrayon.html'    
//    })
//     .when('/crayon/new', {
//        controller: "CrayonNewController as ctrl",
//        templateUrl: 'newCrayon.html'    
//    })
     .when('/medicaments/new', {
        controller: "MedicNewController as ctrl",
        templateUrl: 'newMedicament.html'    
    })
     .when('/medicaments', {
        controller: "MedicController as ctrl",
        templateUrl: 'listeMedicaments.html'    
    })
     .when('/medicaments/edit/:id', {
        controller: "MedicEditController as ctrl",
        templateUrl: 'editMedicament.html'    
    })
     .when('/admissions/edit/:id', {
        controller: "AdmiEditController as ctrl",
        templateUrl: 'editAdmission.html'    
    })
     .when('/admissions', {
        controller: "AdmiController as ctrl",
        templateUrl: 'listeAdmissions.html'    
    })
     .when('/admissions/new', {
        controller: "AdmiNewController as ctrl",
        templateUrl: 'newAdmission.html'    
    })
     .when('/prescriptions', {
        controller: "PrescController as ctrl",
        templateUrl: 'listePrescriptions.html'    
    })
    .when('/prescriptions/:id', {
        controller: "PrescDetailsController as ctrl",
        templateUrl: 'detailsPrescription.html'    
    })
    .when('/prescriptions/iep/:id', {
        controller: "PrescIEPController as ctrl",
        templateUrl: 'listeAdmiPrescriptions.html'
    })
    .when('/prescriptions/ipp/:id', {
        controller: "PrescIPPController as ctrl",
        templateUrl: 'listeAdmiPrescriptions.html'
    })
    .when('/prescriptions/news', {
        controller: "PrescNewController as ctrl",
        templateUrl: 'newPrescription.html'    
    })
    
    .otherwise({ redirectTo: '/'});
}]);

