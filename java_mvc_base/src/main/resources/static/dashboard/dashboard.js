


function compareByPopularity(a, b){
    //This comparer function takes a and b, which are the popularity count tags and does
    // comparison work on their innerHTML (the actual popularity count number).


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
         let popularity_count_tags = Array.from(document.getElementsByClassName
         ("popularity_tag"))

         //sort the popularity count tags with the comparer function
         popularity_count_tags.sort(compareByPopularity)
         let parent_element = document.getElementsByClassName("course_cards")[0]
         var position;

         // loop over the sorted list of count tags and switch positions of their respective grandparent
         // elements (the course cards), reflecting the order of the sorted count tags list.

         for (position = 0; position < popularity_count_tags.length; position++) {

             target_element = popularity_count_tags[position].parentElement.parentElement
             let target_position_element = parent_element.children[position]


             target_position_element.insertAdjacentElement("beforebegin", target_element);
         }


     }
     let filter_button = document.getElementsByClassName("filter-btn")[0]
     filter_button.innerHTML = "Filtered!"
     filter_button.setAttribute("style",
         "background-color: #ed4824; color: white;")


 }


