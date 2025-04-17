const first = require("ee-first");
const { Sequelize, DataTypes } = require("sequelize");

const sequelize = new Sequelize("portfolio", "admin", "admin", {
  define: {
    freezeTableName: true,
    host: "localhost",
    dialect: "postgres",
    timestamps: true,
  },
});

try {
  await sequelize.authenticate();
  console.log("Connection has been established successfully.");
} catch (error) {
  console.error("Unable to connect to the database:", error);
}

const User = sequelize.define(
  "User",
  {
    firstName: DataTypes.STRING,
    lastName: {
      type: DataTypes.STRING,
      allowNull: true,
    },
    email: {
      type: DataTypes.STRING,
      allowNull: false,
      unique: true,
    },
    password: {
      type: DataTypes.STRING,
      allowNull: false,
      unique: true,
    },
  },
  {
    createdAt: false,
    updatedAt: true,
  }
);

await sequelize.sync({ force: true, match: /folio$/ });
console.log("Synchronized successfully!");
