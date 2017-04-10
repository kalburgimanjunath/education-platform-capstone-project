var states = [
    {
        name: 'app.admin',
        url: 'admin',
        params: {
            created_updated: false
        },
        views: {
            'mainContent@app': {
                templateUrl: 'views/admin/home/home.html',
                controller: 'AdminCtrl',
                controllerAs: 'adminCtrl'
            }
        }
    },
    {
        name: 'app.admin.add_edit',
        url: '/{userEmail}/add_edit',
        views: {
            'mainContent@app': {
                templateUrl: 'views/admin/user_add_edit/home.html',
                controller: 'AdminAddEditCtrl',
                controllerAs: 'adminAddEditCtrl'
            }
        },
        resolve : {
            user : ['AdminService', 'SessionService', '$stateParams', '$state', function (AdminService, SessionService, $stateParams, $state) {
                if ($stateParams.userEmail == "new") {
                    return null
                } else {
                    console.log($stateParams.userEmail);
                    return AdminService.getUser($stateParams.userEmail)
                        .then(function (user) {
                            return user;
                        }, function (err) {
                            $state.go('app.admin', null, { reload: true, location: 'replace' });
                            return err;
                        });
                }
            }]
        }
    }
]
module.exports = states;
