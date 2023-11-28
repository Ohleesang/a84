/**
 * 1~1000  s : 들어오는 괄호 문자열
 * [],{},() 가 있는 s가 들어온다.
 * 이때 A가 올바른 문자열이면 [A],{A},(A) 도 올바른 문자열이다.
 *
 * 들어온 s을 회전 시켜서,
 * 올바른 괄호 문자열의 수를 return
 */

const val BIG ="[]"
const val MIDDLE ="{}"
const val SMALL ="()"

class Solution {
    fun solution(s: String): Int {
        var answer: Int = -1
        return answer
    }
}
fun main(){
    var a = Solution()
    a.solution("[](){}")//3
    a.solution("}]()[{")//2
    a.solution("[)(]")//0
    a.solution("}}}")//0
}