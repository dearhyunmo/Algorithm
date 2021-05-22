function solution(array, commands) {
    var result = new Array();
    
    for( var a in commands ){
        result.push( array.slice( commands[a][0]-1, commands[a][1] ).sort((x, y) => x - y)[commands[a][2] -1] );
    }
    
    return result;
}