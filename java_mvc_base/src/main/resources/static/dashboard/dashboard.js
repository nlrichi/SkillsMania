
const btn = document.getElementById("filter-btn");

/* When the user clicks on the button,
 toggle between hiding and showing the dropdown content */
 function myFunction() {
     document.getElementById("myDropdown").classList.toggle("show");
 }


function compareByPopularity(a, b){
     let pop_countA = Number(a.innerHTML.toString().split(" ")[2])
    let pop_countB = Number(b.innerHTML.toString().split(" ")[2])
    console.log(pop_countA + " and " + pop_countB)
     return pop_countB - pop_countA
}

 function filterBy(option) {
     console.log("Starting filtering...")
     let target_element;
     if (option === "popular") {
         //the family tree looks like this: target_parent_div -> polaroid_div(s)
         // -> container div (for info on courses) -> popularity count tags
         let popularity_count_tags = Array.from(document.getElementsByClassName("popularity_tag"))
         popularity_count_tags.sort(compareByPopularity)
         let parent_element = document.getElementsByClassName("course_cards")[0]
         var position;
         for (position = 0; position < popularity_count_tags.length; position++) {
             console.log("loop iterating... " + position.toString())

             target_element = popularity_count_tags[position].parentElement.parentElement
             let target_position_element = parent_element.children[position]
             console.log(target_element.className + " target pos and " + target_position_element.className)
             console.log("\n")

             target_position_element.insertAdjacentElement("beforebegin", target_element);
         }


     }
     console.log("Finished filtering!")

 }


