export default ({
    "defaultpage": "Dashboard",
    menuItemById: [
      {
        id: 1,
        classe: "icon-home",
        title: "Home",
        sousmenu: [1, 2, 3]
      },
      {
        id: 2,
        "title": "Setting",
        "classe": "icon-bar-chart",
        sousmenu: [4, 5]
      }
    ],
    sousMenuItemById: [
      {
        id: 1,
        "template": "calendar",
        "title": "Dashboard",
        classe: "icon-bar-chart"
      },
      {
        id: 2,
        template: "Dashboard2",
        title: "Dashboard2",
        classe: "icon-bulb"
      },
      {
        id: 3,
        template: "Dashboard3",
        title: "Dashboard3",
        classe: "icon-graph"
      },
      {
        id: 4,
        "template": "profile",
        "title": "My account",
        "classe": "icon-graph"
      },
      {
        id: 5,
        "template": "setting",
        "title": "My Setting ",
        "classe": "icon-graph"
      }
    ],
    menu: [1, 2]
 })