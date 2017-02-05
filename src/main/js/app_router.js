

function Router($stateProvider, $httpProvider, $locationProvider){
    "ngInject";

    var states = [
        {
            name : 'app',
            url : '/',
            views : {
                'app' : {
                    templateUrl : 'views/app/home/home.html'
                }
            }
        },
        {
            name : 'app.login',
            url : 'login',
            views : {
                'app@' : {
                    templateUrl : 'views/app/login/login.html',
                    controller: 'LoginCtrl',
                    controllerAs: 'login'
                }
            }
        },
        {
            name : 'app.account',
            url : 'account',
            views : {
                'mainContent@app' : {
                    templateUrl : 'views/app/account/account.html',
                    controller : 'AccountCtrl',
                    controllerAs : 'account'  
                }
            }
        }, 
        {
            name : 'app.courses',
            url : 'courses',
            views : {
                'mainContent@app' : {
                    templateUrl: 'views/student/home/home.html',
                    controller: 'Student.HomeCtrl',
                    controllerAs: 'studentHome' 
                }
            }
        }, 
        {
            name : 'app.course',
            url  : 'courses/{courseId}',
            views : {
                'mainContent@app' : {
                    templateUrl : 'views/student/course/home.html'
                }
            }
        },
        {
            name : 'app.course.assignments',
            url : 'assignments',
            views : {
                'mainContent@app.course' : {
                    templateUrl : 'views/student/assignment/home.html'
                }
            }
        }
    ]

    states.forEach(function(state) {
        $stateProvider.state(state);
    });

    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

//    Removing # from the urls
}

module.exports = Router;
