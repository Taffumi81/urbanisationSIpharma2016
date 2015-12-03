

angular.module('monApp')
        .factory('Crayons', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/crayons/:id', {id: '@id'});

            }])

        .factory('Medicaments', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/medicaments/:id', {id: '@id'});

            }])

        .factory('Admissions', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/admissions/:id', {id: '@id'});

            }])

        .factory('Prescriptions', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/prescriptions/:id', {id: '@id'});

            }])

        .factory('PrescriptionsIEP', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/prescriptions/iep/:id', {id: '@IEP'});

            }])

        .factory('PrescriptionsIPP', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/prescriptions/ipp/:id', {id: '@IPP'});

            }])

        .factory('PrescriptionsState', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/prescriptions/state/:id', {id: '@IPP'});

            }])

        .factory('MedPresc', ['$resource', function ($resource) {

                //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
                return $resource('/bureau/webresources/generic/medpresc/:id', {id: '@id'});

            }])
        ;
