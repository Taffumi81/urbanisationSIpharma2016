
angular.module('monApp')
//        .controller('CrayonsController', ['Crayons',
//            function (Crayons) {
//                this.crayons = Crayons.query();
//                this.delete = function (cr) {
//                    // appel DELETE asynchrone au service web sur /crayons/{id}
//                    //cr.$delete();
//                    Crayons.delete(cr);
//                    // remet à jour le tableau des crayons en suprimant l'élément effacé
//                    this.crayons.splice(this.crayons.indexOf(cr), 1);
//                };
//            }
//        ])


        .controller('MedicController', ['Medicaments', '$location',
            function (Medicament, $location) {
                var self = this;
                this.med = Medicament.query();
                this.edit = function (med) {
                    $location.path("/medicaments/edit/" + med.id);
                };
                this.new = function () {
                    $location.path("/medicaments/new");
                };
            }
        ])


        .controller('MedicNewController', ['Medicaments','$location',
            function (Medicament,$location) {
                var self = this;
                this.med = new Medicament();
                this.update = function () {
                    this.med.$save();
                    $location.path("/medicaments");
                };
            }])



        .controller('MedicEditController', ['$routeParams', 'Medicaments', '$location',
            function ($routeParams, Medicament, $location) {
                this.med = Medicament.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons/{id} 
                    this.med.$save();
                    $location.path("/medicaments")
                };
                this.raz = function () {
                    this.med.stockMed = 0;
                    this.med.$save();
                    $location.path("/medicaments");
                    location.reload();
                };
            }
        ])


        .controller('AdmiController', ['Admissions', '$location',
            function (Admission, $location) {
                var self = this;
                this.ad = Admission.query();
                this.edit = function (ad) {
                    $location.path("/admissions/edit/" + ad.id);
                };
                this.new = function () {
                    $location.path("/admissions/new");
                };
                this.iep = function (ad) {
                    $location.path("/prescriptions/iep/" + ad.IEP);
                };
                this.ipp = function (ad) {
                    $location.path("/prescriptions/ipp/" + ad.IPP);
                };
            }
        ])


        .controller('AdmiNewController', ['Admissions','$location',
            function (Admission,$location) {
                var self = this;
                this.ad = new Admission();
                this.update = function () {
                    this.ad.$save();
                    $location.path("/admissions");
                };
            }
        ])

        .controller('AdmiEditController', ['$routeParams', 'Admissions', '$location',
            function ($routeParams, Admission, $location) {
                this.ad = Admission.get({id: $routeParams.id});
                this.update = function () {
                    this.ad.$save();
                    $location.path("/admissions");
                };
            }
        ])


        .controller('PrescIEPController', ['PrescriptionsIEP', '$location', '$routeParams',
            function (PrescriptionsIEP, $location, $routeParams) {
                var self = this;
                this.pr = PrescriptionsIEP.query({id: $routeParams.id});
                this.new = function () {
                    $location.path("/prescriptions/new");
                };
                this.details = function (pr) {
                    $location.path("/prescriptions/" + pr.idPresc);
                };
            }
        ])

        .controller('PrescIPPController', ['PrescriptionsIPP', '$location', '$routeParams',
            function (PrescriptionsIPP, $location, $routeParams) {
                var self = this;
                this.pr = PrescriptionsIPP.query({id: $routeParams.id});
                this.new = function () {
                    $location.path("/prescriptions/new");
                };
                this.details = function (pr) {
                    $location.path("/prescriptions/" + pr.idPresc);
                };
            }
        ])

        .controller('PrescController', ['Prescriptions', '$location',
            function (Prescriptions, $location) {
                var self = this;
                this.pr = Prescriptions.query();
                this.edit = function (pr) {
                    $location.path("/prescriptions/edit/" + pr.idPresc);
                };
                this.new = function () {
                    $location.path("/prescriptions/new");
                };
                this.details = function (pr) {
                    $location.path("/prescriptions/details/" + pr.idPresc);
                };
            }
        ])


        .controller('PrescDetailsController', ['Prescriptions','PrescriptionsState','Medicaments','MedPresc','$routeParams', '$location',
            function (Prescriptions, PrescriptionsState, Medicaments,MedPresc,$routeParams,$location) {
                var self = this;
                this.medpresc = new MedPresc();
                this.pr = Prescriptions.get({id: $routeParams.id});
                this.med = Medicaments.query(); 
                this.etat = function (pr) {
                    PrescriptionsState.get({id: pr.idPresc});
                    location.reload();
                };
                this.update = function () {
                    this.pr.$save();
//                    $location.path("/prescriptions/");
//                    location.reload(); 
                };
                this.newmedpresc = function () {
                    this.medpresc.$save();
                    this.pr.push(this.medpresc);
                    this.pr.$save();
                    $location.path("/prescriptions/" + pr.idPresc);
                    location.reload();        
                };
            }
        ])
        
        .controller('PrescNewController', ['Prescriptions', 'Admissions', '$location',
            function (Prescriptions,Admissions,$location) {
                var self = this;
                this.d = new Date();
                this.pr = new Prescriptions();
                this.ad = Admissions.query();
                this.update = function () {
                    this.pr.etat = "NonValide";
                    this.pr.date = this.d;
                    this.pr.$save();
                    $location.path("/prescriptions/");
                };
            }
        ]);
//
//
//
//        .controller('CrayonNewController', ['Crayons',
//            function (Crayons) {
//                this.cr = new Crayons();
//                this.update = function () {
//                    // appel POST asynchrone au service web sur /crayons
//                    this.cr.$save();
//                };
//            }
//        ])
//
//
//        .controller('CrayonEditController', ['$routeParams', 'Crayons', '$location',
//            function ($routeParams, Crayons, $location) {
//                this.cr = Crayons.get({id: $routeParams.id});
//                this.update = function () {
//                    // appel POST asynchrone au service web sur /crayons/{id} 
//                    this.cr.$save();
//                    $location.path("/")
//                };
//            }
//        ]);
