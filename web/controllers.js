
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
                this.raz = function (med) {
//                    // appel DELETE asynchrone au service web sur /crayons/{id}
//                    //cr.$delete();
//                    Medicament.delete(med);
//                    // remet à jour le tableau des crayons en suprimant l'élément effacé
//                    self.med.splice(this.med.indexOf(med), 1);

                };
                this.edit = function (med) {
                    $location.path("/medicaments/edit/" + med.id);
                };
                this.new = function () {
                    $location.path("/medicaments/new");
                };
            }
        ])


        .controller('MedicNewController', ['Medicaments',
            function (Medicament) {
                var self = this;
                this.med = new Medicament();
                this.update = function () {
                    this.med.$save();
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
            }
        ])


        .controller('AdmiController', ['Admissions', '$location',
            function (Admission, $location) {
                var self = this;
                this.ad = Admission.query();
                this.delete = function (ad) {
                    Admission.delete(ad);
                    // remet à jour le tableau des crayons en suprimant l'élément effacé
                    self.ad.splice(self.ad.indexOf(ad), 1);
                };
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


        .controller('AdmiNewController', ['Admissions',
            function (Admission) {
                var self = this;
                this.ad = new Admission();
                this.update = function () {
                    this.ad.$save();
                };
            }
        ])

        .controller('AdmiEditController', ['$routeParams', 'Admissions', '$location',
            function ($routeParams, Admission, $location) {
                this.ad = Admission.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons/{id} 
                    this.ad.$save();
                    $location.path("/admissions")
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
                this.delete = function (pr) {
                    // appel DELETE asynchrone au service web sur /crayons/{id}
                    //cr.$delete();
                    Prescriptions.delete(pr);
                    // remet à jour le tableau des crayons en suprimant l'élément effacé
                    self.pr.splice(self.pr.indexOf(pr), 1);
                };
                this.edit = function (pr) {
                    $location.path("/prescriptions/edit/" + pr.idPresc);
                };
                this.new = function () {
                    $location.path("/prescriptions/new");
                };
                this.details = function (pr) {
                    $location.path("/prescriptions/" + pr.idPresc);
                };
            }
        ])


        .controller('PrescDetailsController', ['Prescriptions','PrescriptionsState','Medicaments','$routeParams', '$location',
            function (Prescriptions, PrescriptionsState, Medicaments, $location, $routeParams) {
                var self = this;
//                this.medpresc = new MedPresc();
//                this.pr = Prescriptions.get({id: $routeParams.idPresc});
                this.med = Medicaments.query(); 
                this.etat = function (pr) {
                    PrescriptionsState.get({id: pr.idPresc});
                    location.reload();
                };
//                this.newmedpresc = function () {
//                    this.medpresc.$save();
//                    $location.path("/prescriptions/" + pr.idPresc);
//                    location.reload();        
//                };
            }
        ])
        
        .controller('PrescNewController', ['Prescriptions', 'Admissions',
            function (Prescriptions,Admissions) {
                var self = this;
                this.pr = new Prescriptions();
                this.ad = Admissions.query();
                this.update = function () {
                    this.pr.$save();
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
