/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./Ejercicios/**/*.{html,js}"],
  theme: {
    extend: {
      colors: {
        "purpura": "#7d2181",
      },
      spacing: {
        "41": "192px",
      },
      width: {
        "39": "150px",
      }
    },
  },
  plugins: [],
}

