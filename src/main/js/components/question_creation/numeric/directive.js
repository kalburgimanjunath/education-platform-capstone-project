function Directive($state){
    "ngInject";

    function link(scope, element, attributes){
        scope.model = {
            type : scope.field.questionType
        };

        setAnswer(scope);

    }

    function setAnswer( scope ){
        var _scope = scope;
        scope.$watch('savedAnswers', function(newAnswer){
            if(newAnswer && "value" in newAnswer){
                _scope.model.answer = Number(newAnswer.value.answer);
                _scope.model.unit = newAnswer.value.unit;
            }
        });
    }

    var directive = {
        controller: 'InputComponentController',
        controllerAs: 'componentCtrl',
        templateUrl: 'components/quiz/numeric/home.html',
        link : link,
        scope: {
            model: '=',
            savedAnswers : '=',
            editable : '=',
            field: '='
        }
    }

    return directive;
}

module.exports =  Directive;
