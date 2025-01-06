// Get the restaurant ID from the URL query string
const urlParams = new URLSearchParams(window.location.search);
const restaurantId = urlParams.get('restaurant');

// Sample restaurant data
const restaurantData = {
    1: {
        name: "Indian Accent",
        image: "restaurant1.jpg",
        description: "Modern Indian food with a contemporary twist.",
        location: "The Lodhi, New Delhi",
        contact: "+91 11 4601 1779",
        timings: "Mon-Sun: 12:30 PM - 2:30 PM, 7:00 PM - 11:00 PM",
        cuisine: ["Indian", "Contemporary"],
        reviews: [
            { author: "John Doe", text: "A unique and flavorful experience!" },
            { author: "Jane Smith", text: "Highly recommended for a fine dining experience." }
        ]
    },
    2: {
        name: "Bukhara",
        image: "restaurant2.jpg",
        description: "Famous for its rustic Mughlai cuisine.",
        location: "ITC Maurya, New Delhi",
        contact: "+91 11 2611 2233",
        timings: "Mon-Sun: 12:00 PM - 2:30 PM, 7:00 PM - 11:00 PM",
        cuisine: ["Mughlai", "North Indian"],
        reviews: [
            { author: "Michael Johnson", text: "Best tandoori in town!" },
            { author: "Sarah Lee", text: "Delicious kebabs and naan!" }
        ]
    },
    3: {
        name: "Karim's",
        image: "restaurant3.jpg",
        description: "Famous for its Mughlai and Indian cuisine.",
        location: "Old Delhi, New Delhi",
        contact: "+91 11 2326 0261",
        timings: "Mon-Sun: 10:00 AM - 11:00 PM",
        cuisine: ["Mughlai", "Indian"],
        reviews: [
            { author: "Emily Clark", text: "Authentic Mughlai food!" },
            { author: "William Miller", text: "A true culinary experience!" }
        ]
    },
    4: {
        name: "SodaBottleOpenerWala",
        image: "restaurant4.jpg",
        description: "Parsi and Bombay-style cafe with a quirky vibe.",
        location: "Khan Market, New Delhi",
        contact: "+91 11 4356 6666",
        timings: "Mon-Sun: 12:00 PM - 11:00 PM",
        cuisine: ["Parsi", "Indian"],
        reviews: [
            { author: "Olivia Martinez", text: "Great Parsi dishes!" },
            { author: "David Green", text: "A fun place for Bombay street food!" }
        ]
    },
    5: {
        name: "The Baked & The Fried",
        image: "restaurant5.jpg",
        description: "Known for its delicious bakery and fried items.",
        location: "Saket, New Delhi",
        contact: "+91 11 4262 7777",
        timings: "Mon-Sun: 9:00 AM - 11:00 PM",
        cuisine: ["Bakery", "Cafe"],
        reviews: [
            { author: "Jack Taylor", text: "Great pastries and coffee!" },
            { author: "Lisa Johnson", text: "Perfect for a quick snack!" }
        ]
    },
    6: {
        name: "Moti Mahal Delux",
        image: "restaurant6.jpg",
        description: "The home of the famous butter chicken.",
        location: "Daryaganj, New Delhi",
        contact: "+91 11 2326 1047",
        timings: "Mon-Sun: 12:00 PM - 3:00 PM, 7:00 PM - 11:00 PM",
        cuisine: ["North Indian", "Mughlai"],
        reviews: [
            { author: "James Williams", text: "The butter chicken is legendary!" },
            { author: "Mary Lee", text: "A must-visit for North Indian food!" }
        ]
    },
    7: {
        name: "Masala Library",
        image: "restaurant7.jpg",
        description: "Innovative Indian cuisine with a molecular twist.",
        location: "Janpath, New Delhi",
        contact: "+91 11 4711 0022",
        timings: "Mon-Sun: 12:30 PM - 2:30 PM, 7:00 PM - 11:00 PM",
        cuisine: ["Indian", "Contemporary"],
        reviews: [
            { author: "Henry Robinson", text: "The fusion food is amazing!" },
            { author: "Emily Clarke", text: "A delightful and innovative experience!" }
        ]
    },
    8: {
        name: "The All American Diner",
        image: "restaurant8.jpg",
        description: "Classic American diner serving comfort food.",
        location: "Connaught Place, New Delhi",
        contact: "+91 11 4575 7070",
        timings: "Mon-Sun: 7:00 AM - 11:00 PM",
        cuisine: ["American", "Cafe"],
        reviews: [
            { author: "Sophia Smith", text: "A true American diner experience!" },
            { author: "John Miller", text: "The burgers are fantastic!" }
        ]
    },
    9: {
        name: "Dhaba by Claridges",
        image: "restaurant9.jpg",
        description: "Serving authentic Punjabi cuisine.",
        location: "Claridges, New Delhi",
        contact: "+91 11 3955 5555",
        timings: "Mon-Sun: 12:30 PM - 3:30 PM, 7:00 PM - 11:00 PM",
        cuisine: ["Punjabi", "North Indian"],
        reviews: [
            { author: "Mark Brown", text: "Amazing butter chicken and dal makhani!" },
            { author: "Paul Wilson", text: "Great ambiance and delicious food!" }
        ]
    },
    10: {
        name: "Veda",
        image: "restaurant10.jpg",
        description: "Fine dining with a blend of classic and contemporary Indian flavors.",
        location: "Connaught Place, New Delhi",
        contact: "+91 11 2336 3030",
        timings: "Mon-Sun: 12:30 PM - 2:30 PM, 7:00 PM - 11:00 PM",
        cuisine: ["Indian", "Contemporary"],
        reviews: [
            { author: "David Green", text: "An amazing experience with great flavors!" },
            { author: "Jessica Lee", text: "A fine-dining must-visit!" }
        ]
    },
    11: {
        name: "FIO Cookhouse & Bar",
        image: "restaurant11.jpg",
        description: "A vibrant place for Italian and continental cuisine.",
        location: "Epicuria, Nehru Place, New Delhi",
        contact: "+91 11 4161 1100",
        timings: "Mon-Sun: 12:00 PM - 12:00 AM",
        cuisine: ["Italian", "Continental"],
        reviews: [
            { author: "Lucas Brown", text: "Amazing pasta and cocktails!" },
            { author: "Rebecca White", text: "Loved the ambiance and food!" }
        ]
    },
    12: {
        name: "The Pind Balluchi",
        image: "restaurant12.jpg",
        description: "Traditional Punjabi food with a rustic feel.",
        location: "Netaji Subhash Place, New Delhi",
        contact: "+91 11 2703 3400",
        timings: "Mon-Sun: 12:00 PM - 3:00 PM, 7:00 PM - 11:00 PM",
        cuisine: ["Punjabi", "North Indian"],
        reviews: [
            { author: "Charles Anderson", text: "Authentic Punjabi food!" },
            { author: "Amelia Brown", text: "The best butter chicken and naan!" }
        ]
    },
    13: {
        name: "Café Lota",
        image: "restaurant13.jpg",
        description: "Serving traditional Indian dishes in a contemporary setting.",
        location: "National Crafts Museum, New Delhi",
        contact: "+91 11 2652 2373",
        timings: "Mon-Sun: 9:00 AM - 10:00 PM",
        cuisine: ["Indian", "Cafe"],
        reviews: [
            { author: "Elena Green", text: "A true gem for traditional flavors!" },
            { author: "Sophia Harris", text: "A peaceful place to enjoy authentic Indian food." }
        ]
    },
    14: {
        name: "Pind Balluchi",
        image: "restaurant14.jpg",
        description: "Serving authentic Punjabi food in a vibrant setting.",
        location: "Punjabi Bagh, New Delhi",
        contact: "+91 11 2524 4444",
        timings: "Mon-Sun: 12:00 PM - 11:00 PM",
        cuisine: ["Punjabi", "Indian"],
        reviews: [
            { author: "Chloe Wilson", text: "Best Punjabi food I've ever had!" },
            { author: "Daniel Johnson", text: "A vibrant and welcoming place for a meal!" }
        ]
    },
    15: {
        name: "Olive Bar & Kitchen",
        image: "restaurant15.jpg",
        description: "Mediterranean cuisine with a focus on fresh ingredients.",
        location: "Mehrauli, New Delhi",
        contact: "+91 11 2652 6060",
        timings: "Mon-Sun: 12:30 PM - 11:00 PM",
        cuisine: ["Mediterranean", "European"],
        reviews: [
            { author: "Jack Taylor", text: "Beautiful place with great food!" },
            { author: "Hannah Lee", text: "Amazing Mediterranean cuisine!" }
        ]
    }
};

// Get the current restaurant data based on the restaurant ID
const restaurant = restaurantData[restaurantId];

if (restaurant) {
    // Update the page content with the restaurant's data
    document.getElementById('restaurant-name').textContent = restaurant.name;
    document.getElementById('restaurant-image').src = restaurant.image;
    document.getElementById('restaurant-image').alt = restaurant.name;
    document.getElementById('restaurant-description').textContent = restaurant.description;
    document.getElementById('restaurant-location').textContent = restaurant.location;
    document.getElementById('restaurant-contact').textContent = restaurant.contact;
    document.getElementById('restaurant-timings').textContent = restaurant.timings;
    document.getElementById('restaurant-cuisine').textContent = restaurant.cuisine.join(", ");

    // Dynamically add the reviews
    const reviewsList = document.getElementById('reviews-list');
    restaurant.reviews.forEach(review => {
        const reviewItem = document.createElement('div');
        reviewItem.classList.add('review-item');
        reviewItem.innerHTML = `<p><strong>${review.author}:</strong> ${review.text}</p>`;
        reviewsList.appendChild(reviewItem);
}

// Handle form submission for adding a review
const reviewForm = document.getElementById('review-form');
reviewForm.addEventListener('submit', function(event) {
    event.preventDefault();
    const reviewText = document.getElementById('review-text').value;
    
    if (reviewText) {
        const newReview = {
            author: "Anonymous", // You can replace with the user's name if they are logged in
            text: reviewText
        };

        // Add the new review to the restaurant (In a real application, this would also need to update the backend)
        restaurant.reviews.push(newReview);

        // Append the new review to the list
        const reviewItem = document.createElement('div');
        reviewItem.classList.add('review-item');
        reviewItem.innerHTML = `<p><strong>${newReview.author}:</strong> ${newReview.text}</p>`;
        reviewsList.appendChild(reviewItem);

        // Clear the review form
        document.getElementById('review-text').value = '';
    }
});
